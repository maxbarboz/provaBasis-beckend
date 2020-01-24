package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface AvaliacaoListagemMapper extends EntityMapper<AvaliacaoListagemDTO, Avaliacao> {

    @Override
    @Mapping(source = "idDisciplina", target = "disciplina.id")
    Avaliacao toEntity(AvaliacaoListagemDTO avaliacaoListagemDTO);

    @Override
    @Mapping(source = "disciplina.id", target = "idDisciplina")
    AvaliacaoListagemDTO toDto(Avaliacao avaliacao);
}

