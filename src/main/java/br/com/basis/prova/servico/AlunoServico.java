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

        if (!verificaMatriculaECpf(aluno))
            throw new RegraNegocioException("Já existe essa Matrícula ou Cpf nos dados.");

        return alunoMapper.toDto(alunoRepositorio.save(aluno));
    }

    public void excluir(String matricula) {
        Aluno alunoMatricula = alunoRepositorio.findByMatricula(matricula);

        if(alunoMatricula == null)
            throw new RegraNegocioException("Matrícula não encontrada nos dados.");
        else
            if (!(alunoComDisciplinas(matricula)))
                throw new RegraNegocioException("O aluno possui disciplinas cadastradas.");

        alunoRepositorio.delete(alunoMatricula);

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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean verificaMatriculaECpf(Aluno aluno){
        Aluno alunoMatricula = alunoRepositorio.findByMatricula(aluno.getMatricula());
        Aluno alunoCpf = alunoRepositorio.findByCpf(aluno.getCpf());

        if( alunoCpf == null || alunoCpf.getId().equals(aluno.getId()) )
            if( alunoMatricula == null || alunoMatricula.getId().equals(aluno.getId()))
            return true;

        return false;
    }

    private boolean alunoComDisciplinas(String matricula){
        Aluno aluno = alunoRepositorio.findByMatricula(matricula);

        if( aluno.getDisciplinas().size() == 0 )
            return true;

        return false;
    }
}
