package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-24T10:40:23-0300",
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
        avaliacao.setData( dto.getData() );
        avaliacao.setDisciplina( dto.getDisciplina() );

        return avaliacao;
    }

    @Override
    public AvaliacaoDTO toDto(Avaliacao entity) {
        if ( entity == null ) {
            return null;
        }

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        avaliacaoDTO.setId( entity.getId() );
        avaliacaoDTO.setData( entity.getData() );
        avaliacaoDTO.setDisciplina( entity.getDisciplina() );

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
}
