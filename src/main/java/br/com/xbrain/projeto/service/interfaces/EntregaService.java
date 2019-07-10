package br.com.xbrain.projeto.service.interfaces;

import br.com.xbrain.projeto.model.Entrega;

import java.util.List;

public interface EntregaService {

    Entrega salvar(Entrega entrega);

    List<Entrega> buscarTudo();
}
