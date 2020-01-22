package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.dominio.dto.ProfessorListagemDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.ProfessorDetalhadoMapper;
import br.com.basis.prova.servico.mapper.ProfessorListagemMapper;
import br.com.basis.prova.servico.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        if (verificaMatricula(professor))
            throw new RegraNegocioException("Já existe essa Matrícula nos dados.");

        return professorMapper.toDto(professorRepositorio.save(professor));
    }

    // CORRETO
    public void excluir(String matricula) {
        Professor professorMatricula = professorRepositorio.findByMatricula(matricula);

        if(professorMatricula == null){
            throw new RegraNegocioException("Matrícula não encontrada nos dados.");
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
                () -> new RegraNegocioException("Registro não encontrado")
        );
        return professorDetalhadoMapper.toDto(professor);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // RECURSO DO SERVICO
    private boolean verificaMatricula(Professor professor) {
        Professor professorMatricula = professorRepositorio.findByMatricula(professor.getMatricula());

        if( !(professorMatricula == null || professorMatricula.getId().equals(professor.getId())))
            return true;

        return false;
    }

}
