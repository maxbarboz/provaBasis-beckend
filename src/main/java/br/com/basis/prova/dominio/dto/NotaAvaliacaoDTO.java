package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class NotaAvaliacaoDTO {

    @NotNull
    private Integer id;

    @NotNull
    private Integer idAluno;

    @NotNull
    private Integer idAvaliacao;

    @NotNull
    private Double nota;

}
