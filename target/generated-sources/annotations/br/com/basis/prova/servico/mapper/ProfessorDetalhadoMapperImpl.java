package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-22T09:03:26-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class ProfessorDetalhadoMapperImpl implements ProfessorDetalhadoMapper {

    @Autowired
    private DisciplinaListagemMapper disciplinaListagemMapper;

    @Override
    public Professor toEntity(ProfessorDetalhadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( dto.getId() );
        professor.setNome( dto.getNome() );
        professor.setMatricula( dto.getMatricula() );
        professor.setDisciplinas( disciplinaDTOListToDisciplinaList( dto.getDisciplinas() ) );

        return professor;
    }

    @Override
    public ProfessorDetalhadoDTO toDto(Professor entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessorDetalhadoDTO professorDetalhadoDTO = new ProfessorDetalhadoDTO();

        professorDetalhadoDTO.setId( entity.getId() );
        professorDetalhadoDTO.setNome( entity.getNome() );
        professorDetalhadoDTO.setMatricula( entity.getMatricula() );
        professorDetalhadoDTO.setDisciplinas( disciplinaListToDisciplinaDTOList( entity.getDisciplinas() ) );

        return professorDetalhadoDTO;
    }

    @Override
    public List<Professor> toEntity(List<ProfessorDetalhadoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( dtoList.size() );
        for ( ProfessorDetalhadoDTO professorDetalhadoDTO : dtoList ) {
            list.add( toEntity( professorDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<ProfessorDetalhadoDTO> toDto(List<Professor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfessorDetalhadoDTO> list = new ArrayList<ProfessorDetalhadoDTO>( entityList.size() );
        for ( Professor professor : entityList ) {
            list.add( toDto( professor ) );
        }

        return list;
    }

    protected Disciplina disciplinaDTOToDisciplina(DisciplinaDTO disciplinaDTO) {
        if ( disciplinaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaDTO.getId() );
        disciplina.setNome( disciplinaDTO.getNome() );
        disciplina.setDescricao( disciplinaDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDTO.getAtiva() );
        disciplina.setProfessor( disciplinaDTO.getProfessor() );

        return disciplina;
    }

    protected List<Disciplina> disciplinaDTOListToDisciplinaList(List<DisciplinaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaDTO disciplinaDTO : list ) {
            list1.add( disciplinaDTOToDisciplina( disciplinaDTO ) );
        }

        return list1;
    }

    protected DisciplinaDTO disciplinaToDisciplinaDTO(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        disciplinaDTO.setId( disciplina.getId() );
        disciplinaDTO.setNome( disciplina.getNome() );
        disciplinaDTO.setDescricao( disciplina.getDescricao() );
        disciplinaDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDTO.setAtiva( disciplina.getAtiva() );
        disciplinaDTO.setProfessor( disciplina.getProfessor() );

        return disciplinaDTO;
    }

    protected List<DisciplinaDTO> disciplinaListToDisciplinaDTOList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaDTO> list1 = new ArrayList<DisciplinaDTO>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaDTO( disciplina ) );
        }

        return list1;
    }
}
