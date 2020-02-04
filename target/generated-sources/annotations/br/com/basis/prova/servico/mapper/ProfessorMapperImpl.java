package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-04T09:41:27-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class ProfessorMapperImpl implements ProfessorMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public Professor toEntity(ProfessorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( dto.getId() );
        professor.setNome( dto.getNome() );
        professor.setMatricula( dto.getMatricula() );
        professor.setArea( dto.getArea() );
        professor.setDataNascimento( dto.getDataNascimento() );
        professor.setDisciplinas( disciplinaListagemDTOListToDisciplinaList( dto.getDisciplinas() ) );

        return professor;
    }

    @Override
    public ProfessorDTO toDto(Professor entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setId( entity.getId() );
        professorDTO.setNome( entity.getNome() );
        professorDTO.setMatricula( entity.getMatricula() );
        professorDTO.setArea( entity.getArea() );
        professorDTO.setDataNascimento( entity.getDataNascimento() );
        professorDTO.setDisciplinas( disciplinaListToDisciplinaListagemDTOList( entity.getDisciplinas() ) );

        return professorDTO;
    }

    @Override
    public List<Professor> toEntity(List<ProfessorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( dtoList.size() );
        for ( ProfessorDTO professorDTO : dtoList ) {
            list.add( toEntity( professorDTO ) );
        }

        return list;
    }

    @Override
    public List<ProfessorDTO> toDto(List<Professor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfessorDTO> list = new ArrayList<ProfessorDTO>( entityList.size() );
        for ( Professor professor : entityList ) {
            list.add( toDto( professor ) );
        }

        return list;
    }

    protected Disciplina disciplinaListagemDTOToDisciplina(DisciplinaListagemDTO disciplinaListagemDTO) {
        if ( disciplinaListagemDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaListagemDTO.getId() );
        disciplina.setNome( disciplinaListagemDTO.getNome() );
        disciplina.setDescricao( disciplinaListagemDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaListagemDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaListagemDTO.getAtiva() );

        return disciplina;
    }

    protected List<Disciplina> disciplinaListagemDTOListToDisciplinaList(List<DisciplinaListagemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaListagemDTO disciplinaListagemDTO : list ) {
            list1.add( disciplinaListagemDTOToDisciplina( disciplinaListagemDTO ) );
        }

        return list1;
    }

    protected DisciplinaListagemDTO disciplinaToDisciplinaListagemDTO(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaListagemDTO disciplinaListagemDTO = new DisciplinaListagemDTO();

        disciplinaListagemDTO.setId( disciplina.getId() );
        disciplinaListagemDTO.setNome( disciplina.getNome() );
        disciplinaListagemDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaListagemDTO.setAtiva( disciplina.getAtiva() );
        disciplinaListagemDTO.setDescricao( disciplina.getDescricao() );

        return disciplinaListagemDTO;
    }

    protected List<DisciplinaListagemDTO> disciplinaListToDisciplinaListagemDTOList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaListagemDTO> list1 = new ArrayList<DisciplinaListagemDTO>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaListagemDTO( disciplina ) );
        }

        return list1;
    }
}
