package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProfessorMapper.class})
public interface DisciplinaMapper extends EntityMapper<DisciplinaDTO, Disciplina> {
}
