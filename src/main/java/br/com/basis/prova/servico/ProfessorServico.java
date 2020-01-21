package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
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

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);

        return professorMapper.toDto(professorRepositorio.save(professor));
    }

    public void excluir(String matricula, ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);

        if(!verificaMatricula(professor, matricula)){
            throw new RegraNegocioException("Matrícula não encontrada nos dados.");
        }

        /*else if(!verificaProfessorMateria(professor, matricula)){
            throw new RegraNegocioException("O professor possui ministra uma ou mais disciplinas.");
        }*/

       professorRepositorio.delete(professorRepositorio.findByMatricula(matricula));

    }
    private boolean verificaMatricula(Professor professor, String matricula){
        Professor professorMatricula = professorRepositorio.findByMatricula(professor.getMatricula());
        return !(professorMatricula == null);
    }

    private boolean verificaProfessorMateria(Professor professor, String matricula){
        if(professorRepositorio.findByMatricula(matricula).getMatricula() == null){
            return true;
        }
        return false;
    }

    public List<ProfessorListagemDTO> consultar() {
        List <Professor> professor = professorRepositorio.findAll();
        return new ArrayList<>(professorListagemMapper.toDto(professor));
    }

    public ProfessorDetalhadoDTO detalhar(Integer id) {
        Professor professor = professorRepositorio.findById(id).orElseThrow(
                () -> new RegraNegocioException("Registro não encontrado")
        );
        return professorDetalhadoMapper.toDto(professor);
    }

}
