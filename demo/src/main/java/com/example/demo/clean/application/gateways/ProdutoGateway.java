package com.example.demo.clean.application.gateways;

import java.util.List;

import com.example.demo.clean.entities.Produto;

public interface ProdutoGateway {
    
    public List<Produto> findAll();

    public Produto findById(Integer id);

    public Produto save(Produto produto);

    public boolean deleteById(Integer id);

    public boolean deleteAll();

    public Integer count();


}
