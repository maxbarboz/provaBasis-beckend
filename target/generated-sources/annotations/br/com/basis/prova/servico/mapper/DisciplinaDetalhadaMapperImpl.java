package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-07T12:50:47-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class DisciplinaDetalhadaMapperImpl implements DisciplinaDetalhadaMapper {

    @Autowired
    private DisciplinaListagemMapper disciplinaListagemMapper;

    @Override
    public Disciplina toEntity(DisciplinaDetalhadaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( dto.getId() );
        disciplina.setNome( dto.getNome() );
        disciplina.setDescricao( dto.getDescricao() );
        disciplina.setCargaHoraria( dto.getCargaHoraria() );
        disciplina.setAtiva( dto.getAtiva() );
        disciplina.setProfessor( professorDTOToProfessor( dto.getProfessor() ) );
        disciplina.setAlunos( alunoListagemDTOListToAlunoList( dto.getAlunos() ) );

        return disciplina;
    }

    @Override
    public DisciplinaDetalhadaDTO toDto(Disciplina entity) {
        if ( entity == null ) {
            return null;
        }

        DisciplinaDetalhadaDTO disciplinaDetalhadaDTO = new DisciplinaDetalhadaDTO();

        disciplinaDetalhadaDTO.setId( entity.getId() );
        disciplinaDetalhadaDTO.setNome( entity.getNome() );
        disciplinaDetalhadaDTO.setDescricao( entity.getDescricao() );
        disciplinaDetalhadaDTO.setCargaHoraria( entity.getCargaHoraria() );
        disciplinaDetalhadaDTO.setAtiva( entity.getAtiva() );
        disciplinaDetalhadaDTO.setProfessor( professorToProfessorDTO( entity.getProfessor() ) );
        disciplinaDetalhadaDTO.setAlunos( alunoListToAlunoListagemDTOList( entity.getAlunos() ) );

        return disciplinaDetalhadaDTO;
    }

    @Override
    public List<Disciplina> toEntity(List<DisciplinaDetalhadaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaDetalhadaDTO disciplinaDetalhadaDTO : dtoList ) {
            list.add( toEntity( disciplinaDetalhadaDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaDetalhadaDTO> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaDetalhadaDTO> list = new ArrayList<DisciplinaDetalhadaDTO>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }

    protected Professor professorDTOToProfessor(ProfessorDTO professorDTO) {
        if ( professorDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorDTO.getId() );
        professor.setNome( professorDTO.getNome() );
        professor.setMatricula( professorDTO.getMatricula() );
        professor.setArea( professorDTO.getArea() );
        professor.setDataNascimento( professorDTO.getDataNascimento() );
        professor.setDisciplinas( disciplinaListagemMapper.toEntity( professorDTO.getDisciplinas() ) );

        return professor;
    }

    protected Aluno alunoListagemDTOToAluno(AlunoListagemDTO alunoListagemDTO) {
        if ( alunoListagemDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoListagemDTO.getId() );
        aluno.setMatricula( alunoListagemDTO.getMatricula() );
        aluno.setNome( alunoListagemDTO.getNome() );
        aluno.setDataNascimento( alunoListagemDTO.getDataNascimento() );

        return aluno;
    }

    protected List<Aluno> alunoListagemDTOListToAlunoList(List<AlunoListagemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Aluno> list1 = new ArrayList<Aluno>( list.size() );
        for ( AlunoListagemDTO alunoListagemDTO : list ) {
            list1.add( alunoListagemDTOToAluno( alunoListagemDTO ) );
        }

        return list1;
    }

    protected ProfessorDTO professorToProfessorDTO(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setId( professor.getId() );
        professorDTO.setNome( professor.getNome() );
        professorDTO.setMatricula( professor.getMatricula() );
        professorDTO.setArea( professor.getArea() );
        professorDTO.setDataNascimento( professor.getDataNascimento() );
        professorDTO.setDisciplinas( disciplinaListagemMapper.toDto( professor.getDisciplinas() ) );

        return professorDTO;
    }

    protected AlunoListagemDTO alunoToAlunoListagemDTO(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoListagemDTO alunoListagemDTO = new AlunoListagemDTO();

        alunoListagemDTO.setId( aluno.getId() );
        alunoListagemDTO.setNome( aluno.getNome() );
        alunoListagemDTO.setMatricula( aluno.getMatricula() );
        alunoListagemDTO.setDataNascimento( aluno.getDataNascimento() );

        return alunoListagemDTO;
    }

    protected List<AlunoListagemDTO> alunoListToAlunoListagemDTOList(List<Aluno> list) {
        if ( list == null ) {
            return null;
        }

        List<AlunoListagemDTO> list1 = new ArrayList<AlunoListagemDTO>( list.size() );
        for ( Aluno aluno : list ) {
            list1.add( alunoToAlunoListagemDTO( aluno ) );
        }

        return list1;
    }
}
