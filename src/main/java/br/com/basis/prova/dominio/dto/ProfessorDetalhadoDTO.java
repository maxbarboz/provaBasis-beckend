package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDetalhadoDTO {

	private Integer id;
    private String nome;
    private String matricula;
    private List<DisciplinaDTO> disciplinas = new ArrayList<>();

    
}
