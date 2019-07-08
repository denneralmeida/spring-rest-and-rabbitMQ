package br.com.xbrain.projeto.service.interfaces;

import br.com.xbrain.projeto.model.Produto;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;

import java.util.List;


public interface ProdutoService {

    Produto salvar(Produto produto) throws DuplicateException;

    Produto buscar(Integer id);

    void excluir(Integer id);

    List<Produto> buscarTudo();

    boolean exists(Produto produto);
}
