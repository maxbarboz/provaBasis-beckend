package br.com.basis.prova.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "AVALIACAO")
@Getter
@Setter
@NoArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @Column(name= "NOTA", nullable = false)
    private Double nota;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA", nullable = false)
    @NotNull
    private LocalDate data;

    @NotNull
    @JoinColumn(name= "ID_DISCIPLINA", referencedColumnName = "ID")
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Disciplina disciplina;

    @NotNull
    @JoinColumn(name= "ID_ALUNO", referencedColumnName = "ID")
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Aluno aluno;

}