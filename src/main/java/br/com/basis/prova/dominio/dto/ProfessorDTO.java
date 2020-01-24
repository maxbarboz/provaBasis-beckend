package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String nome;

    @Size(min = 6, max = 6)
    @NotNull
    private String matricula;

    @Size(min = 1, max = 200)
    private String area;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

}
