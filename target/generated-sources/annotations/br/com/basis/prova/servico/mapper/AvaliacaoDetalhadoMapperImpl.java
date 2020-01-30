package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.NotaAvaliacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-30T08:43:49-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AvaliacaoDetalhadoMapperImpl implements AvaliacaoDetalhadoMapper {

    @Override
    public Avaliacao toEntity(AvaliacaoDetalhadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setData( dto.getData() );
        avaliacao.setNotaAvaliacao( notaAvaliacaoDTOListToNotaAvaliacaoList( dto.getNotaAvaliacao() ) );

        return avaliacao;
    }

    @Override
    public AvaliacaoDetalhadoDTO toDto(Avaliacao entity) {
        if ( entity == null ) {
            return null;
        }

        AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO = new AvaliacaoDetalhadoDTO();

        avaliacaoDetalhadoDTO.setData( entity.getData() );
        avaliacaoDetalhadoDTO.setNotaAvaliacao( notaAvaliacaoListToNotaAvaliacaoDTOList( entity.getNotaAvaliacao() ) );

        return avaliacaoDetalhadoDTO;
    }

    @Override
    public List<Avaliacao> toEntity(List<AvaliacaoDetalhadoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Avaliacao> list = new ArrayList<Avaliacao>( dtoList.size() );
        for ( AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO : dtoList ) {
            list.add( toEntity( avaliacaoDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<AvaliacaoDetalhadoDTO> toDto(List<Avaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AvaliacaoDetalhadoDTO> list = new ArrayList<AvaliacaoDetalhadoDTO>( entityList.size() );
        for ( Avaliacao avaliacao : entityList ) {
            list.add( toDto( avaliacao ) );
        }

        return list;
    }

    protected NotaAvaliacao notaAvaliacaoDTOToNotaAvaliacao(NotaAvaliacaoDTO notaAvaliacaoDTO) {
        if ( notaAvaliacaoDTO == null ) {
            return null;
        }

        NotaAvaliacao notaAvaliacao = new NotaAvaliacao();

        notaAvaliacao.setId( notaAvaliacaoDTO.getId() );
        notaAvaliacao.setNota( notaAvaliacaoDTO.getNota() );

        return notaAvaliacao;
    }

    protected List<NotaAvaliacao> notaAvaliacaoDTOListToNotaAvaliacaoList(List<NotaAvaliacaoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<NotaAvaliacao> list1 = new ArrayList<NotaAvaliacao>( list.size() );
        for ( NotaAvaliacaoDTO notaAvaliacaoDTO : list ) {
            list1.add( notaAvaliacaoDTOToNotaAvaliacao( notaAvaliacaoDTO ) );
        }

        return list1;
    }

    protected NotaAvaliacaoDTO notaAvaliacaoToNotaAvaliacaoDTO(NotaAvaliacao notaAvaliacao) {
        if ( notaAvaliacao == null ) {
            return null;
        }

        NotaAvaliacaoDTO notaAvaliacaoDTO = new NotaAvaliacaoDTO();

        notaAvaliacaoDTO.setId( notaAvaliacao.getId() );
        notaAvaliacaoDTO.setNota( notaAvaliacao.getNota() );

        return notaAvaliacaoDTO;
    }

    protected List<NotaAvaliacaoDTO> notaAvaliacaoListToNotaAvaliacaoDTOList(List<NotaAvaliacao> list) {
        if ( list == null ) {
            return null;
        }

        List<NotaAvaliacaoDTO> list1 = new ArrayList<NotaAvaliacaoDTO>( list.size() );
        for ( NotaAvaliacao notaAvaliacao : list ) {
            list1.add( notaAvaliacaoToNotaAvaliacaoDTO( notaAvaliacao ) );
        }

        return list1;
    }
}
