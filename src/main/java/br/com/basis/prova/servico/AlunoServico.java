package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoListagemMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Transactional
public class AlunoServico {

    private AlunoMapper alunoMapper;
    private AlunoRepositorio alunoRepositorio;
    private AlunoListagemMapper alunoListagemMapper;
    private AlunoDetalhadoMapper alunoDetalhadoMapper;

    public AlunoServico(AlunoMapper alunoMapper, AlunoRepositorio alunoRepositorio, AlunoListagemMapper alunoListagemMapper, AlunoDetalhadoMapper alunoDetalhadoMapper) {
        this.alunoMapper = alunoMapper;
        this.alunoRepositorio = alunoRepositorio;
        this.alunoListagemMapper = alunoListagemMapper;
        this.alunoDetalhadoMapper = alunoDetalhadoMapper;
    }

    public AlunoDTO salvar(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);

        if(verificarCPF(aluno)){
            throw new RegraNegocioException("CPF já existe");
        }

        return alunoMapper.toDto(alunoRepositorio.save(aluno));
    }
    public void excluir(String matricula, AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);

        if(!verificaMatricula(aluno, matricula)){
            throw new RegraNegocioException("Matrícula não encontrada nos dados.");
        }

        /*else if(!verificaAlunoMateria(aluno, matricula)){
            throw new RegraNegocioException("O aluno possui uma ou mais disciplinas cadastradas.");
        }*/

        alunoRepositorio.delete(alunoRepositorio.findByMatricula(matricula));
    }

    private boolean verificaMatricula(Aluno aluno, String matricula){
        Aluno alunoMatricula = alunoRepositorio.findByMatricula(aluno.getMatricula());
        return !(alunoMatricula == null);
    }

    private boolean verificaAlunoMateria(Aluno aluno, String matricula){
        if(alunoRepositorio.findByMatricula(matricula).getMatricula() == null){
            return true;
        }

        return false;
    }

    private boolean verificarCPF(Aluno aluno) {
        Aluno alunoCpf = alunoRepositorio.findByCpf(aluno.getCpf());
        return !(alunoCpf == null || alunoCpf.getId().equals(aluno.getId()));
    }

    public List<AlunoListagemDTO> consultar() {
        List <Aluno> alunos = alunoRepositorio.findAll();
        return new ArrayList<>(alunoListagemMapper.toDto(alunos));
    }

    public AlunoDetalhadoDTO detalhar(Integer id) {
        Aluno aluno = alunoRepositorio.findById(id).orElseThrow(
                () -> new RegraNegocioException("Registro não encontrado")
        );
        return alunoDetalhadoMapper.toDto(aluno);
    }

}
