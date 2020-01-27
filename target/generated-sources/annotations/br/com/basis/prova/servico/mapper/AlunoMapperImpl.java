package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-27T11:11:59-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public Aluno toEntity(AlunoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( dto.getId() );
        aluno.setMatricula( dto.getMatricula() );
        aluno.setCpf( dto.getCpf() );
        aluno.setNome( dto.getNome() );
        if ( dto.getDataNascimento() != null ) {
            aluno.setDataNascimento( java.time.LocalDateTime.ofInstant( dto.getDataNascimento().toInstant(), java.time.ZoneOffset.UTC ).toLocalDate() );
        }
        aluno.setDisciplinas( disciplinaListagemDTOListToDisciplinaList( dto.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public AlunoDTO toDto(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId( entity.getId() );
        alunoDTO.setNome( entity.getNome() );
        alunoDTO.setCpf( entity.getCpf() );
        alunoDTO.setMatricula( entity.getMatricula() );
        if ( entity.getDataNascimento() != null ) {
            alunoDTO.setDataNascimento( java.util.Date.from( entity.getDataNascimento().atStartOfDay( java.time.ZoneOffset.UTC ).toInstant() ) );
        }
        alunoDTO.setDisciplinas( disciplinaListToDisciplinaListagemDTOList( entity.getDisciplinas() ) );

        return alunoDTO;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoDTO alunoDTO : dtoList ) {
            list.add( toEntity( alunoDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoDTO> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoDTO> list = new ArrayList<AlunoDTO>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
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
