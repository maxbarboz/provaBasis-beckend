package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.servico.AlunoServico;
import br.com.basis.prova.servico.mapper.AlunoListagemMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoListagemDTO { // DTO usado para consulta simples de alunos

    private Integer id;
    private String nome;
    private String matricula;
    @JsonIgnore
    private LocalDate dataNascimento;
    private Integer idade;

}
