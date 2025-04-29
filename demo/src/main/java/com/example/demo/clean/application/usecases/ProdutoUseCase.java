package com.example.demo.clean.application.usecases;

import java.util.List;

import com.example.demo.clean.entities.Produto;

public interface ProdutoUseCase {
    
    public List<Produto> findAll();

    public Produto findById(Integer id);

    public Produto save(Produto produto);

    public boolean deleteById(Integer id);

    public boolean deleteAll();

    public Integer count();

}
