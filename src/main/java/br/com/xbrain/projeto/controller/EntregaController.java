package br.com.xbrain.projeto.controller;


import br.com.xbrain.projeto.model.Entrega;
import br.com.xbrain.projeto.model.Pedido;
import br.com.xbrain.projeto.service.interfaces.EntregaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@CrossOrigin
@RequestMapping("/api/entregas")
@RestController
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @RabbitListener(queues = "${queue.name}")
    public void novaEntrega(Pedido pedido) {
        Entrega entrega = new Entrega();
        entrega.setEnderecoEntrega(pedido.getEnderecoEntrega());
        entrega.setPedido(pedido);

        entregaService.salvar(entrega);
        System.out.println("Nova entrega...");
    }

    @GetMapping
    public List<Entrega> entregas() {
        return entregaService.buscarTudo();
    }


}
