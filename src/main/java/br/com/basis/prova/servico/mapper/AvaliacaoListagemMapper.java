package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface AvaliacaoListagemMapper extends EntityMapper<AvaliacaoListagemDTO, Avaliacao> {

    @Override
    @Mapping(source = "idDisciplina", target = "disciplina.id")
    @Mapping(source = "nomeDisciplina", target = "disciplina.nome")
    Avaliacao toEntity(AvaliacaoListagemDTO avaliacaoListagemDTO);

    @Override
    @Mapping(source = "disciplina.id", target = "idDisciplina")
    @Mapping(source = "disciplina.nome", target = "nomeDisciplina")
    AvaliacaoListagemDTO toDto(Avaliacao avaliacao);
}

