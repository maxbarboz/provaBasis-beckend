package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoListagemDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private LocalDate data;

    @NotNull
    private Integer idDisciplina;

    @NotNull
    private String nomeDisciplina;
}
