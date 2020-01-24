package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.NotaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaAvaliacaoRepositorio extends JpaRepository<NotaAvaliacao, Integer>, JpaSpecificationExecutor<NotaAvaliacao> {
}