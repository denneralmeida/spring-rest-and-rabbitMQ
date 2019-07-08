package br.com.xbrain.projeto.controller;

import br.com.xbrain.projeto.model.Cliente;
import br.com.xbrain.projeto.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> produtos() {
        return clienteService.buscarTudo();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Integer id) {
        return clienteService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@Valid @RequestBody Cliente produto) {
        return clienteService.salvar(produto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Cliente alterar(@Valid @RequestBody Cliente produto) {
        return clienteService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
    }
}


