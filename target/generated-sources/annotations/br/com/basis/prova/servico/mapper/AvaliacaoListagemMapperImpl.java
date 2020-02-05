package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-05T10:53:26-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AvaliacaoListagemMapperImpl implements AvaliacaoListagemMapper {

    @Override
    public Avaliacao toEntity(AvaliacaoListagemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setId( dto.getId() );
        avaliacao.setNota( dto.getNota() );
        avaliacao.setData( dto.getData() );

        return avaliacao;
    }

    @Override
    public AvaliacaoListagemDTO toDto(Avaliacao entity) {
        if ( entity == null ) {
            return null;
        }

        AvaliacaoListagemDTO avaliacaoListagemDTO = new AvaliacaoListagemDTO();

        avaliacaoListagemDTO.setId( entity.getId() );
        avaliacaoListagemDTO.setNota( entity.getNota() );
        avaliacaoListagemDTO.setData( entity.getData() );

        return avaliacaoListagemDTO;
    }

    @Override
    public List<Avaliacao> toEntity(List<AvaliacaoListagemDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Avaliacao> list = new ArrayList<Avaliacao>( dtoList.size() );
        for ( AvaliacaoListagemDTO avaliacaoListagemDTO : dtoList ) {
            list.add( toEntity( avaliacaoListagemDTO ) );
        }

        return list;
    }

    @Override
    public List<AvaliacaoListagemDTO> toDto(List<Avaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AvaliacaoListagemDTO> list = new ArrayList<AvaliacaoListagemDTO>( entityList.size() );
        for ( Avaliacao avaliacao : entityList ) {
            list.add( toDto( avaliacao ) );
        }

        return list;
    }
}
