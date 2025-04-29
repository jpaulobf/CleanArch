package com.example.demo.clean.infrastructure.gateways;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.domains.entities.Produto;
import com.example.demo.clean.infrastructure.persistence.ProdutoEntity;
import com.example.demo.clean.infrastructure.persistence.ProdutoPersistence;

public class ProdutoGatewayImpl implements ProdutoGateway {

    private final ProdutoPersistence produtoPersistence;

    public ProdutoGatewayImpl(ProdutoPersistence produtoPersistence) {
        this.produtoPersistence = produtoPersistence;
    }

    @Override
    public List<Produto> findAll() {
        return produtoPersistence.findAll().stream()
                .map(produtoEntity -> new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getQuantidade(), produtoEntity.getPreco()))
                .collect(Collectors.toList());
    }

    @Override
    public Produto findById(int id) {
        return produtoPersistence.findById(id).map(produtoEntity -> new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getQuantidade(), produtoEntity.getPreco())).orElse(null);
    }

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity(produto.id(), produto.nome(), produto.descricao(), produto.quantidade(), produto.preco());
        return new Produto(produtoPersistence.save(entity).getId(), entity.getNome(), entity.getDescricao(), entity.getQuantidade(), entity.getPreco());
    }

    @Override
    public boolean deleteById(int id) {
        if (produtoPersistence.existsById(id)) {
            produtoPersistence.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        if (produtoPersistence.count() > 0) {
            produtoPersistence.deleteAll();
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return (int) produtoPersistence.count();
    }
}
