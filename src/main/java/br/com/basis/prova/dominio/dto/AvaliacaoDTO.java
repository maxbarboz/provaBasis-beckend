package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoDTO {

    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private LocalDate data;

    @NotNull
    private Disciplina disciplina;

    private List<NotaAvaliacaoDTO> notaAvaliacao;

}
