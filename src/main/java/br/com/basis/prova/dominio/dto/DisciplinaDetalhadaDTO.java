package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDetalhadaDTO {

    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @NotNull
    @Size(min = 1, max = 200)
    private String descricao;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Integer cargaHoraria;

    @NotNull
    private Integer ativa;

    @NotNull( message = "É necessario ter um professor vinculado a disciplina.")
    private ProfessorDTO professor;

    private List<AlunoListagemDTO> alunos = new ArrayList<>();

}
