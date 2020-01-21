package br.com.basis.prova.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DISCIPLINA")
@Getter
@Setter
@NoArgsConstructor
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
    private Integer id;

	@NotNull
    @Size(min = 4, max = 50)
    @Column(name = "NOME", nullable = false)
    private String nome;

	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "DESCRICAO", nullable = false)
    private String descricao;

	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "CARGA_HORARIA", nullable = false)
    private Integer cargaHoraria;

	@Column(name = "ATIVA")
	@NotNull
    private Integer ativa;

    @JoinColumn(name= "ID_PROFESSOR", referencedColumnName = "ID")
	@ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Professor professor;

}
