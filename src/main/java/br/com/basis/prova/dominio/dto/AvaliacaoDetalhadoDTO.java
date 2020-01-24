package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoDetalhadoDTO {

    @NotNull
    private LocalDate data;

    @ManyToMany
    private List<NotaAvaliacaoDTO> notaAvaliacao;
}
