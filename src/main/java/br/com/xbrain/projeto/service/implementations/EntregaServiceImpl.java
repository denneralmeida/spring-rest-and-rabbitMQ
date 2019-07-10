package br.com.xbrain.projeto.service.implementations;

import br.com.xbrain.projeto.model.Entrega;
import br.com.xbrain.projeto.repository.EntregaRepository;
import br.com.xbrain.projeto.service.interfaces.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Override
    public Entrega salvar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> buscarTudo() {
        return entregaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
