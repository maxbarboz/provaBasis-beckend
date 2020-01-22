package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaListagemDTO {

    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Integer cargaHoraria;

    @NotNull
    @Size(min = 1, max = 200)
    private String descricao;

}
