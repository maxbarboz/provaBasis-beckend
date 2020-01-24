package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.NotaAvaliacaoListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface NotaAvaliacaoListagemMapper extends EntityMapper <NotaAvaliacaoListagemDTO, NotaAvaliacao> {

    @Override
    @Mapping(source = "idAluno", target = "aluno.id")
    NotaAvaliacao toEntity(NotaAvaliacaoListagemDTO notaAvaliacaoListagemDTO);

    @Override
    @Mapping(source = "aluno.id", target = "idAluno")
    NotaAvaliacaoListagemDTO toDto(NotaAvaliacao notaAvaliacao);

}
