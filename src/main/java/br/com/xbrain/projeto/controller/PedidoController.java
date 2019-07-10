package br.com.xbrain.projeto.controller;

import br.com.xbrain.projeto.model.Pedido;
import br.com.xbrain.projeto.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> produtos() {
        return pedidoService.buscarTudo();
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable UUID id) {
        return pedidoService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar(@Valid @RequestBody Pedido produto) {
        return pedidoService.salvar(produto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Pedido alterar(@Valid @RequestBody Pedido produto) {
        return pedidoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable UUID id) {
        pedidoService.excluir(id);
    }
}
