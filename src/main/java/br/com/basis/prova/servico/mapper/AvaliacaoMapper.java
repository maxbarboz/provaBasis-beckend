package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AvaliacaoMapper extends EntityMapper<AvaliacaoDTO, Avaliacao> {
}
