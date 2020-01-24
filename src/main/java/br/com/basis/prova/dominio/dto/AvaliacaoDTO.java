package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Disciplina;
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
    private LocalDate data;

    @NotNull
    private Disciplina disciplina;

}
