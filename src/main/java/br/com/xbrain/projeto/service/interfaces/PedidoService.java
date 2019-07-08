package br.com.xbrain.projeto.service.interfaces;

import br.com.xbrain.projeto.model.Pedido;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;

import java.util.List;
import java.util.UUID;

public interface PedidoService {

    Pedido salvar(Pedido pedido) throws DuplicateException;

    Pedido buscar(UUID id);

    void excluir(UUID id);

    List<Pedido> buscarTudo();

}
