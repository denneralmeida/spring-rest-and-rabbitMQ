package br.com.xbrain.projeto.repository;

import br.com.xbrain.projeto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    boolean existsByDescricaoAndIdNot(String descricao, Integer id);

    boolean existsByDescricao(String descricao);

}
