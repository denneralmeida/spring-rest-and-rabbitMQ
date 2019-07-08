package br.com.xbrain.projeto.service.implementations;

import br.com.xbrain.projeto.model.Cliente;
import br.com.xbrain.projeto.repository.ClienteRepository;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;
import br.com.xbrain.projeto.service.exceptions.NotFoundException;
import br.com.xbrain.projeto.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente salvar(Cliente cliente) {
        if (!existe(cliente)) return clienteRepository.save(cliente);
        else throw new DuplicateException("Já existe este cliente cadastrado.");
    }

    @Override
    public Cliente buscar(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
    }

    @Override
    public void excluir(Integer id) {
        clienteRepository.delete(buscar(id));
    }

    @Override
    public List<Cliente> buscarTudo() {
        return clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public boolean existe(Cliente cliente) {
        if (cliente.getId() == null) return clienteRepository.existsByCpf(cliente.getCpf());
        return clienteRepository.existsByCpfAndIdNot(cliente.getCpf(), cliente.getId());
    }
}
