package br.com.xbrain.projeto.service.interfaces;

import br.com.xbrain.projeto.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente salvar(Cliente cliente);

    Cliente buscar(Integer id);

    void excluir(Integer id);

    List<Cliente> buscarTudo();

    boolean existe(Cliente cliente);
}
