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

import java.time.LocalDate;
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

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);
        verificaMatricula(professor);
        return professorMapper.toDto(professorRepositorio.save(professor));
    }

    public void excluir(String matricula) {
        Professor professorMatricula = professorComDisciplinas(matricula);
        professorRepositorio.delete(professorMatricula);
    }

    public List<ProfessorListagemDTO> consultar() {
        List <Professor> professor = professorRepositorio.findAll();
        List<ProfessorListagemDTO> professorComIdade = professorListagemMapper.toDto(professor);
        acrescentaIdade(professorComIdade);
        return new ArrayList<>(professorComIdade);

    }

    public ProfessorDetalhadoDTO detalhar(Integer id) {

        Professor professor = professorRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("Registro não encontrado")
        );
        return professorDetalhadoMapper.toDto(professor);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void verificaMatricula(Professor professor) {
        Professor professorMatricula = professorRepositorio.findByMatricula(professor.getMatricula());

        if(!(professorMatricula == null)){
            if(!(professorMatricula.getId().equals(professor.getId())) ) {
                throw new RegraNegocioException("Matrícula já encontrada nos dados");
            }
        }
    }

    private Professor professorComDisciplinas(String matricula){
        Professor professorMatricula = professorRepositorio.findByMatricula(matricula);

        if(professorMatricula == null) {
            throw new RegistroNaoEncontradoException("Matrícula não encontrada nos dados.");
        }else {
            if( !(professorMatricula.getDisciplinas().size() == 0) ) {
                throw new RegraNegocioException("O professor ministra alguma disciplina.");
            }
        }

        return professorMatricula;
    }

    private void acrescentaIdade(List<ProfessorListagemDTO> professores){
        LocalDate localDate = LocalDate.now();
        Integer alunoYears;

        for (Integer var = 0; var < professores.size(); var++){
            alunoYears = professores.get(var).getDataNascimento().getYear();
            professores.get(var).setIdade( localDate.getYear() - alunoYears);
        }
    }

}
