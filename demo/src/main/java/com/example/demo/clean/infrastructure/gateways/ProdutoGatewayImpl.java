package com.example.demo.clean.infrastructure.gateways;

import java.util.List;

import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.entities.Produto;
import com.example.demo.clean.infrastructure.persistence.ProdutoEntity;
import com.example.demo.clean.infrastructure.persistence.ProdutoPersistence;

public class ProdutoGatewayImpl implements ProdutoGateway {

    private final ProdutoPersistence produtoRepository;

    public ProdutoGatewayImpl(ProdutoPersistence produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll().stream()
                .map(produtoEntity -> new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getQuantidade(), produtoEntity.getPreco()))
                .toList();
    }

    @Override
    public Produto findById(Integer id) {
        return produtoRepository.findById(id)
                .map(produtoEntity -> new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getQuantidade(), produtoEntity.getPreco()))
                .orElse(null);
    }

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(), produto.getPreco());
        ProdutoEntity savedProdutoEntity = produtoRepository.save(produtoEntity);
        return new Produto(savedProdutoEntity.getId(), savedProdutoEntity.getNome(), savedProdutoEntity.getDescricao(), savedProdutoEntity.getQuantidade(), savedProdutoEntity.getPreco());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteAll() {
        if (produtoRepository.count() > 0) {
            produtoRepository.deleteAll();
            return true;
        }
        return false;

    }

    @Override
    public Integer count() {
        return (int) produtoRepository.count();
    }
}
