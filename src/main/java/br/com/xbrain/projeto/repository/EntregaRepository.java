package br.com.xbrain.projeto.repository;

import br.com.xbrain.projeto.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository  extends JpaRepository<Entrega, Integer> {
}
