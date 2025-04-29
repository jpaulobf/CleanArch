package com.example.demo.mvc.model.services;

import com.example.demo.mvc.model.entities.Produto;
import com.example.demo.mvc.model.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return (this.produtoRepository.findAll());
    }

    public Produto findById(Integer id) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
        return optionalProduto.orElse(null);
    }

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public boolean deleteById(Integer id) {
        try {
            this.produtoRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean deleteAll() {
        try {
            this.produtoRepository.deleteAll();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public Integer count() {
        return Math.toIntExact(this.produtoRepository.count());
    }
}
