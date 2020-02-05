package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoListagemMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        verificaCpf(aluno);
        verificaMatricula(aluno);

        return alunoMapper.toDto(alunoRepositorio.save(aluno));
    }

    public void excluir(String matricula) {
        Aluno alunoMatricula = alunoComDisciplinas(matricula);
        alunoRepositorio.delete(alunoMatricula);
    }

    public List<AlunoListagemDTO> consultar() {
        List <Aluno> alunos = alunoRepositorio.findAll();
        List<AlunoListagemDTO> alunosComIdade = alunoListagemMapper.toDto(alunos);
        acrescentaIdade(alunosComIdade);
        return new ArrayList<>(alunosComIdade);
    }

    public AlunoDTO detalhar(Integer id) {

        Aluno aluno = alunoRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("Registro não encontrado")
        );
        return alunoMapper.toDto(aluno);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void verificaMatricula(Aluno aluno) {
        Aluno alunoMatricula = alunoRepositorio.findByMatricula(aluno.getMatricula());

        if(!(alunoMatricula == null)){
            if(!(alunoMatricula.getId().equals(aluno.getId())) ) {
                throw new RegraNegocioException("Matrícula já encontrada nos dados");
            }
        }
    }

    private void verificaCpf(Aluno aluno){
        Aluno alunoCpf = alunoRepositorio.findByCpf(aluno.getCpf());

        if(!(alunoCpf == null)){
            if(!(alunoCpf.getId().equals(aluno.getId())) ) {
                throw new RegraNegocioException("Cpf já encontrado nos dados");
            }
        }
    }

    private Aluno alunoComDisciplinas(String matricula){

        Aluno alunoMatricula = alunoRepositorio.findByMatricula(matricula);

        if(alunoMatricula == null) {
            throw new RegistroNaoEncontradoException("Matrícula não encontrada nos dados.");
        }else if(!(alunoMatricula.getDisciplinas().size() == 0)){
            throw new RegraNegocioException("O aluno possui disciplinas cadastradas.");
        }

        return alunoMatricula;
    }

    private void acrescentaIdade(List<AlunoListagemDTO> alunos){
        LocalDate localDate = LocalDate.now();
        Integer alunoYears;

        for (Integer var = 0; var < alunos.size(); var++){
            alunoYears = alunos.get(var).getDataNascimento().getYear();
            alunos.get(var).setIdade( localDate.getYear() - alunoYears);
        }
    }

}
