package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDetalhadoDTO { // DTO usado para a consulta detalhada de um aluno

    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @NotNull
    @Size(min = 6, max = 6)
    private String matricula;

    private List<DisciplinaListagemDTO> disciplinas = new ArrayList<>();

    private List<AvaliacaoDetalhadoDTO> avaliacoes = new ArrayList<>();

}
