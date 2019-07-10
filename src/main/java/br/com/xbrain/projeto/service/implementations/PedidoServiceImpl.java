package br.com.xbrain.projeto.service.implementations;

import br.com.xbrain.projeto.model.Pedido;
import br.com.xbrain.projeto.repository.PedidoRepository;
import br.com.xbrain.projeto.service.amqp.AmqpTemplate;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;
import br.com.xbrain.projeto.service.exceptions.NotFoundException;
import br.com.xbrain.projeto.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private AmqpTemplate template;

    @Override
    public Pedido salvar(Pedido pedido) throws DuplicateException {
        return resolver(pedido);
    }

    @Override
    public Pedido buscar(UUID id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    @Override
    public void excluir(UUID id) {
        pedidoRepository.delete(buscar(id));
    }

    @Override
    public List<Pedido> buscarTudo() {
        return pedidoRepository.findAll();
    }

    private Pedido resolver(Pedido pedido) {
        Pedido pedidoAux = pedidoRepository.save(pedido);

        pedidoAux.setValorTotal(pedidoAux.getProdutos().stream().mapToDouble(x -> x.getValor()).sum());
        if (pedidoAux.getEnderecoEntrega() == null)
            pedidoAux.setEnderecoEntrega(pedidoAux.getCliente().getEndereco()); //se não for informado o endereço, o sistema atribui o endereço do cliente

        Pedido pedidoSalvo = pedidoRepository.save(pedidoAux);

        if (pedidoSalvo != null) {
            template.produceMessage(pedido);
        }

        return pedidoSalvo;
    }
}
