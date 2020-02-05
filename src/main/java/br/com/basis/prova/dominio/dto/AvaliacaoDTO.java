package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    private AlunoListagemDTO Aluno;

    @NotNull
    private DisciplinaListagemDTO disciplina;


}
