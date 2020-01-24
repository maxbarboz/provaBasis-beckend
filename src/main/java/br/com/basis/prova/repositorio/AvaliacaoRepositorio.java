package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepositorio extends JpaRepository<Avaliacao, Integer>, JpaSpecificationExecutor<Avaliacao>{
}

