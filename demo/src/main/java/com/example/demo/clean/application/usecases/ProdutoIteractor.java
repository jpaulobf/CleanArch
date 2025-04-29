package com.example.demo.clean.application.usecases;

import java.util.List;

import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.entities.Produto;

public class ProdutoIteractor implements ProdutoUseCase {


    private final ProdutoGateway produtoGateway;

    public ProdutoIteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> findAll() {
        return produtoGateway.findAll();
    }

    @Override
    public Produto findById(Integer id) {
        return produtoGateway.findById(id);
    }

    @Override
    public Produto save(Produto produto) {
        return produtoGateway.save(produto);
    }

    @Override
    public boolean deleteById(Integer id) {
        return produtoGateway.deleteById(id);
    }

    @Override
    public boolean deleteAll() {
        return produtoGateway.deleteAll();
    }

    @Override
    public Integer count() {
        return produtoGateway.count();
    }
    
}
