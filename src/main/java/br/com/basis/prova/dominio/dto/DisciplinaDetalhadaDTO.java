package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Professor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDetalhadaDTO {
	
    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Integer cargaHoraria;

    @NotNull
    private ProfessorDTO professor;
    
}
