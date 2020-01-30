package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.NotaAvaliacaoListagemDTO;
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
public class NotaAvaliacaoListagemMapperImpl implements NotaAvaliacaoListagemMapper {

    @Override
    public List<NotaAvaliacao> toEntity(List<NotaAvaliacaoListagemDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<NotaAvaliacao> list = new ArrayList<NotaAvaliacao>( dtoList.size() );
        for ( NotaAvaliacaoListagemDTO notaAvaliacaoListagemDTO : dtoList ) {
            list.add( toEntity( notaAvaliacaoListagemDTO ) );
        }

        return list;
    }

    @Override
    public List<NotaAvaliacaoListagemDTO> toDto(List<NotaAvaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NotaAvaliacaoListagemDTO> list = new ArrayList<NotaAvaliacaoListagemDTO>( entityList.size() );
        for ( NotaAvaliacao notaAvaliacao : entityList ) {
            list.add( toDto( notaAvaliacao ) );
        }

        return list;
    }

    @Override
    public NotaAvaliacao toEntity(NotaAvaliacaoListagemDTO notaAvaliacaoListagemDTO) {
        if ( notaAvaliacaoListagemDTO == null ) {
            return null;
        }

        NotaAvaliacao notaAvaliacao = new NotaAvaliacao();

        notaAvaliacao.setAluno( notaAvaliacaoListagemDTOToAluno( notaAvaliacaoListagemDTO ) );
        notaAvaliacao.setNota( notaAvaliacaoListagemDTO.getNota() );

        return notaAvaliacao;
    }

    @Override
    public NotaAvaliacaoListagemDTO toDto(NotaAvaliacao notaAvaliacao) {
        if ( notaAvaliacao == null ) {
            return null;
        }

        NotaAvaliacaoListagemDTO notaAvaliacaoListagemDTO = new NotaAvaliacaoListagemDTO();

        Integer id = notaAvaliacaoAlunoId( notaAvaliacao );
        if ( id != null ) {
            notaAvaliacaoListagemDTO.setIdAluno( id );
        }
        notaAvaliacaoListagemDTO.setNota( notaAvaliacao.getNota() );

        return notaAvaliacaoListagemDTO;
    }

    protected Aluno notaAvaliacaoListagemDTOToAluno(NotaAvaliacaoListagemDTO notaAvaliacaoListagemDTO) {
        if ( notaAvaliacaoListagemDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( notaAvaliacaoListagemDTO.getIdAluno() );

        return aluno;
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
}
