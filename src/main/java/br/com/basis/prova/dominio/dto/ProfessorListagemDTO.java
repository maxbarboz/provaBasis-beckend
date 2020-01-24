package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorListagemDTO {

	 private Integer id;

	 @NotNull
	 @Size(min = 1, max = 50)
	 private String nome;

	 @NotNull
	 @Size(min = 6, max = 6)
	 private String matricula;

	 @Size(min = 1, max = 200)
	 private String area;

	 @JsonIgnore
	 private LocalDate dataNascimento;

	 private Integer idade;

}
