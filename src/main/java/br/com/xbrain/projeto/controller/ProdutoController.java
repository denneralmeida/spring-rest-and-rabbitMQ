package br.com.xbrain.projeto.controller;

import br.com.xbrain.projeto.model.Produto;
import br.com.xbrain.projeto.service.amqp.AmqpTemplate;
import br.com.xbrain.projeto.service.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private AmqpTemplate template;

    @GetMapping
    public List<Produto> produtos() {
        return produtoService.buscarTudo();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Integer id) {
        return produtoService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@Valid @RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Produto alterar(@Valid @RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
    }

    @GetMapping("/send")
    public void send(@PathParam(value = "msg") String msg){
        template.produceMessage(msg);
    }
}
