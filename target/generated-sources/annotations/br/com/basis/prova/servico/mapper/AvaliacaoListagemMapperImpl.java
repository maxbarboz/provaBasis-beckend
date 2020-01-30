package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
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
public class AvaliacaoListagemMapperImpl implements AvaliacaoListagemMapper {

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

    @Override
    public Avaliacao toEntity(AvaliacaoListagemDTO avaliacaoListagemDTO) {
        if ( avaliacaoListagemDTO == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setDisciplina( avaliacaoListagemDTOToDisciplina( avaliacaoListagemDTO ) );
        avaliacao.setId( avaliacaoListagemDTO.getId() );
        avaliacao.setData( avaliacaoListagemDTO.getData() );

        return avaliacao;
    }

    @Override
    public AvaliacaoListagemDTO toDto(Avaliacao avaliacao) {
        if ( avaliacao == null ) {
            return null;
        }

        AvaliacaoListagemDTO avaliacaoListagemDTO = new AvaliacaoListagemDTO();

        Integer id = avaliacaoDisciplinaId( avaliacao );
        if ( id != null ) {
            avaliacaoListagemDTO.setIdDisciplina( id );
        }
        avaliacaoListagemDTO.setId( avaliacao.getId() );
        avaliacaoListagemDTO.setData( avaliacao.getData() );

        return avaliacaoListagemDTO;
    }

    protected Disciplina avaliacaoListagemDTOToDisciplina(AvaliacaoListagemDTO avaliacaoListagemDTO) {
        if ( avaliacaoListagemDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( avaliacaoListagemDTO.getIdDisciplina() );

        return disciplina;
    }

    private Integer avaliacaoDisciplinaId(Avaliacao avaliacao) {
        if ( avaliacao == null ) {
            return null;
        }
        Disciplina disciplina = avaliacao.getDisciplina();
        if ( disciplina == null ) {
            return null;
        }
        Integer id = disciplina.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
