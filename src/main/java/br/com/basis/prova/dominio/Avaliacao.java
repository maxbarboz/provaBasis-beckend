package br.com.basis.prova.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA", nullable = false)
    @NotNull
    private LocalDate data;

    @NotNull
    @JoinColumn(name = "ID_DISCIPLINA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <NotaAvaliacao> notaAvaliacao = new ArrayList<>();
}