package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoDTO {

    private Integer id;

    @NotNull
    private Double nota;

    @NotNull
    private LocalDate data;

    @NotNull
    private AlunoListagemDTO Aluno;

    @NotNull
    private DisciplinaListagemDTO disciplina;


}
