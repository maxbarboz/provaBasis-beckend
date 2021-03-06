package br.com.basis.prova.dominio.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {
	
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

}
