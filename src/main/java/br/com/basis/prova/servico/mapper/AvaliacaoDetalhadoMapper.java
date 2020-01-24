package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AvaliacaoMapper.class})
public interface AvaliacaoDetalhadoMapper  extends EntityMapper<AvaliacaoDetalhadoDTO, Avaliacao> {
}
