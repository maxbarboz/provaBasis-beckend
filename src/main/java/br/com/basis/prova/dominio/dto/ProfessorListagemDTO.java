package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorListagemDTO {

	 private Integer id;
	 private String nome;
	 private String matricula;
	 private String area;
	 @JsonIgnore
	 private LocalDate dataNascimento;
	 private Integer idade;
	 private List<DisciplinaDTO> disciplinas = new ArrayList<>();

}
