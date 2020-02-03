package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AlunoListagemMapper.class})
public interface AvaliacaoListagemMapper extends EntityMapper<AvaliacaoListagemDTO, Avaliacao> {

}

