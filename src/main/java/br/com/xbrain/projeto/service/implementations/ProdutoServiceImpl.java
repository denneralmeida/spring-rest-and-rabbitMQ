package br.com.xbrain.projeto.service.implementations;

import br.com.xbrain.projeto.model.Produto;
import br.com.xbrain.projeto.repository.ProdutoRepository;
import br.com.xbrain.projeto.service.exceptions.DuplicateException;
import br.com.xbrain.projeto.service.exceptions.NotFoundException;
import br.com.xbrain.projeto.service.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        if (!exists(produto)) return produtoRepository.save(produto);
        else throw new DuplicateException("Já existe este produto cadastrado.");
    }

    @Override
    public Produto buscar(Integer id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Produto não encontrado")
        );
    }

    @Override
    public void excluir(Integer id) {
        produtoRepository.delete(buscar(id));
    }

    @Override
    public List<Produto> buscarTudo() {
        return produtoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public boolean exists(Produto produto) {
        if (produto.getId() == null) {
            return produtoRepository.existsByDescricao(produto.getDescricao());
        }
        return produtoRepository.existsByDescricaoAndIdNot(produto.getDescricao(), produto.getId());
    }
}
