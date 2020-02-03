package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-03T07:13:46-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AvaliacaoMapperImpl implements AvaliacaoMapper {

    @Override
    public Avaliacao toEntity(AvaliacaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setId( dto.getId() );
        avaliacao.setNota( dto.getNota() );
        avaliacao.setData( dto.getData() );
        avaliacao.setDisciplina( disciplinaListagemDTOToDisciplina( dto.getDisciplina() ) );
        avaliacao.setAluno( alunoListagemDTOToAluno( dto.getAluno() ) );

        return avaliacao;
    }

    @Override
    public AvaliacaoDTO toDto(Avaliacao entity) {
        if ( entity == null ) {
            return null;
        }

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        avaliacaoDTO.setId( entity.getId() );
        avaliacaoDTO.setNota( entity.getNota() );
        avaliacaoDTO.setData( entity.getData() );
        avaliacaoDTO.setAluno( alunoToAlunoListagemDTO( entity.getAluno() ) );
        avaliacaoDTO.setDisciplina( disciplinaToDisciplinaListagemDTO( entity.getDisciplina() ) );

        return avaliacaoDTO;
    }

    @Override
    public List<Avaliacao> toEntity(List<AvaliacaoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Avaliacao> list = new ArrayList<Avaliacao>( dtoList.size() );
        for ( AvaliacaoDTO avaliacaoDTO : dtoList ) {
            list.add( toEntity( avaliacaoDTO ) );
        }

        return list;
    }

    @Override
    public List<AvaliacaoDTO> toDto(List<Avaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AvaliacaoDTO> list = new ArrayList<AvaliacaoDTO>( entityList.size() );
        for ( Avaliacao avaliacao : entityList ) {
            list.add( toDto( avaliacao ) );
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
}
