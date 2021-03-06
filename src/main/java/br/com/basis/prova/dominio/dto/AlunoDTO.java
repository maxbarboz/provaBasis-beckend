package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDTO { // DTO usado para salvar e editar um aluno

    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    @CPF( message = "Cpf inválido" )
    private String cpf;

    @NotNull
    @Size(min = 6, max = 6)
    private String matricula;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private List<DisciplinaListagemDTO> disciplinas = new ArrayList<>();

    private List<AvaliacaoDetalhadoDTO> avaliacoes = new ArrayList<>();

}
