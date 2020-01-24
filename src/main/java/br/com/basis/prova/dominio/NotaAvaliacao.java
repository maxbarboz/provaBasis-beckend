package br.com.basis.prova.dominio;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ALUNO_AVALIACAO")
@Getter
@Setter
@NoArgsConstructor
public class NotaAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID" )
    @OneToOne( optional = false, fetch = FetchType.LAZY )
    private Aluno aluno;

    @NotNull
    @Column(name = "NOTA")
    private Double nota;

    @NotNull
    @JoinColumn(name = "ID_AVALIACAO", referencedColumnName = "ID")
    @OneToOne( optional = false, fetch = FetchType.LAZY )
    private Avaliacao avaliacao;

}
