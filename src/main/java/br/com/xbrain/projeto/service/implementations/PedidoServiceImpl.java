package br.com.xbrain.projeto.service.implementations;

import br.com.xbrain.projeto.model.Pedido;
import br.com.xbrain.projeto.model.Produto;
import br.com.xbrain.projeto.repository.PedidoRepository;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;
import br.com.xbrain.projeto.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido salvar(Pedido pedido) throws DuplicateException {
        pedido.setEnderecoEntrega(pedido.getCliente().getEndereco());
        //pedido.getProdutos().stream().mapToDouble(x -> x.getValor()).sum());
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido buscar(UUID id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ValidationException("Pedido não encontrado"));
    }

    @Override
    public void excluir(UUID id) {
        pedidoRepository.delete(buscar(id));
    }

    @Override
    public List<Pedido> buscarTudo() {
        return pedidoRepository.findAll();
    }
}
