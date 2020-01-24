package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.NotaAvaliacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface NotaAvaliacaoMapper extends EntityMapper<NotaAvaliacaoDTO, NotaAvaliacao> {

    @Override
    @Mapping(source = "idAluno", target = "aluno.id")
    @Mapping(source = "idAvaliacao", target = "avaliacao.id")
    NotaAvaliacao toEntity(NotaAvaliacaoDTO notaAvaliacaoDTO);

    @Override
    @Mapping(source = "aluno.id", target = "idAluno")
    @Mapping(source = "avaliacao.id", target = "idAvaliacao")
    NotaAvaliacaoDTO toDto(NotaAvaliacao notaAvaliacao);

}
