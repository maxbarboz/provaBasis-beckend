package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.NotaAvaliacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-30T11:48:15-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class NotaAvaliacaoMapperImpl implements NotaAvaliacaoMapper {

    @Override
    public List<NotaAvaliacao> toEntity(List<NotaAvaliacaoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<NotaAvaliacao> list = new ArrayList<NotaAvaliacao>( dtoList.size() );
        for ( NotaAvaliacaoDTO notaAvaliacaoDTO : dtoList ) {
            list.add( toEntity( notaAvaliacaoDTO ) );
        }

        return list;
    }

    @Override
    public List<NotaAvaliacaoDTO> toDto(List<NotaAvaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NotaAvaliacaoDTO> list = new ArrayList<NotaAvaliacaoDTO>( entityList.size() );
        for ( NotaAvaliacao notaAvaliacao : entityList ) {
            list.add( toDto( notaAvaliacao ) );
        }

        return list;
    }

    @Override
    public NotaAvaliacao toEntity(NotaAvaliacaoDTO notaAvaliacaoDTO) {
        if ( notaAvaliacaoDTO == null ) {
            return null;
        }

        NotaAvaliacao notaAvaliacao = new NotaAvaliacao();

        notaAvaliacao.setAluno( notaAvaliacaoDTOToAluno( notaAvaliacaoDTO ) );
        notaAvaliacao.setAvaliacao( notaAvaliacaoDTOToAvaliacao( notaAvaliacaoDTO ) );
        notaAvaliacao.setId( notaAvaliacaoDTO.getId() );
        notaAvaliacao.setNota( notaAvaliacaoDTO.getNota() );

        return notaAvaliacao;
    }

    @Override
    public NotaAvaliacaoDTO toDto(NotaAvaliacao notaAvaliacao) {
        if ( notaAvaliacao == null ) {
            return null;
        }

        NotaAvaliacaoDTO notaAvaliacaoDTO = new NotaAvaliacaoDTO();

        Integer id = notaAvaliacaoAlunoId( notaAvaliacao );
        if ( id != null ) {
            notaAvaliacaoDTO.setIdAluno( id );
        }
        Integer id1 = notaAvaliacaoAvaliacaoId( notaAvaliacao );
        if ( id1 != null ) {
            notaAvaliacaoDTO.setIdAvaliacao( id1 );
        }
        notaAvaliacaoDTO.setId( notaAvaliacao.getId() );
        notaAvaliacaoDTO.setNota( notaAvaliacao.getNota() );

        return notaAvaliacaoDTO;
    }

    protected Aluno notaAvaliacaoDTOToAluno(NotaAvaliacaoDTO notaAvaliacaoDTO) {
        if ( notaAvaliacaoDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( notaAvaliacaoDTO.getIdAluno() );

        return aluno;
    }

    protected Avaliacao notaAvaliacaoDTOToAvaliacao(NotaAvaliacaoDTO notaAvaliacaoDTO) {
        if ( notaAvaliacaoDTO == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setId( notaAvaliacaoDTO.getIdAvaliacao() );

        return avaliacao;
    }

    private Integer notaAvaliacaoAlunoId(NotaAvaliacao notaAvaliacao) {
        if ( notaAvaliacao == null ) {
            return null;
        }
        Aluno aluno = notaAvaliacao.getAluno();
        if ( aluno == null ) {
            return null;
        }
        Integer id = aluno.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer notaAvaliacaoAvaliacaoId(NotaAvaliacao notaAvaliacao) {
        if ( notaAvaliacao == null ) {
            return null;
        }
        Avaliacao avaliacao = notaAvaliacao.getAvaliacao();
        if ( avaliacao == null ) {
            return null;
        }
        Integer id = avaliacao.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
