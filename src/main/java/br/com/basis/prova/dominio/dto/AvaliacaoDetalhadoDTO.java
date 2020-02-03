package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoDetalhadoDTO {

    private Integer id;

    @NotNull
    private Double nota;

    @NotNull
    private LocalDate data;

    @NotNull
    private DisciplinaListagemDTO disciplina;

    @NotNull
    private AlunoListagemDTO aluno;
}
