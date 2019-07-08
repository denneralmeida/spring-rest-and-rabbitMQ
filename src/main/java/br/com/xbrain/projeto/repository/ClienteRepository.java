package br.com.xbrain.projeto.repository;

import br.com.xbrain.projeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCpfAndIdNot(String cpf, Integer id);

    boolean existsByCpf(String cpf);
}
