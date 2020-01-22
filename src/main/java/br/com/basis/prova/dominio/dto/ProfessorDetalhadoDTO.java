package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDetalhadoDTO {

	private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String nome;

    @NotNull
    @Size(min = 6, max = 6)
    private String matricula;

    private List<DisciplinaListagemDTO> disciplinas = new ArrayList<>();

}
