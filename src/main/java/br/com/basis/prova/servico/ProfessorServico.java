package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.dominio.dto.ProfessorListagemDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.ProfessorDetalhadoMapper;
import br.com.basis.prova.servico.mapper.ProfessorListagemMapper;
import br.com.basis.prova.servico.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfessorServico {

    private ProfessorRepositorio professorRepositorio;
    private ProfessorMapper professorMapper;
    private ProfessorListagemMapper professorListagemMapper;
    private ProfessorDetalhadoMapper professorDetalhadoMapper;

    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    public ProfessorServico(ProfessorMapper professorMapper, ProfessorRepositorio professorRepositorio, ProfessorListagemMapper professorListagemMapper, ProfessorDetalhadoMapper professorDetalhadoMapper) {
        this.professorMapper = professorMapper;
        this.professorRepositorio = professorRepositorio;
        this.professorListagemMapper = professorListagemMapper;
        this.professorDetalhadoMapper = professorDetalhadoMapper;
    }

    // CORRETO
    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);

        if (verificaMatricula(professor)) {
            throw new RegraNegocioException("Já existe essa Matrícula nos dados.");
        }

        return professorMapper.toDto(professorRepositorio.save(professor));
    }

    // CORRETO
    public void excluir(String matricula) {
        Professor professorMatricula = professorRepositorio.findByMatricula(matricula);

        if(professorMatricula == null) {
            throw new RegistroNaoEncontradoException("Matrícula não encontrada nos dados.");
        }else {
            if (!(professorComDisciplinas(matricula))) {
                throw new RegraNegocioException("O professor ministra alguma disciplina.");
            }
        }
        professorRepositorio.delete(professorMatricula);

    }

    // CORRETO
    public List<ProfessorListagemDTO> consultar() {
        List <Professor> professor = professorRepositorio.findAll();
        return new ArrayList<>(professorListagemMapper.toDto(professor));
    }
    // CORRETO

    public ProfessorDetalhadoDTO detalhar(Integer id) {
        Professor professor = professorRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("Registro não encontrado")
        );
        return professorDetalhadoMapper.toDto(professor);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // RECURSO DO SERVICO
    private boolean verificaMatricula(Professor professor) {
        Professor professorMatricula = professorRepositorio.findByMatricula(professor.getMatricula());

        if( !(professorMatricula == null || professorMatricula.getId().equals(professor.getId()))) {
            return true;
        }

        return false;
    }
    private boolean professorComDisciplinas(String matricula){
        Professor professor = professorRepositorio.findByMatricula(matricula);

        if( professor.getDisciplinas().size() == 0 ) {
            return true;
        }

        return false;
    }

}
