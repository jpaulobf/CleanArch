package com.example.demo.clean.application.gateways;

import java.util.List;
import com.example.demo.clean.domains.entities.Produto;

public interface ProdutoGateway {
    
    List<Produto> findAll();
    Produto findById(int id);
    Produto save(Produto produto);
    boolean deleteById(int id);
    boolean deleteAll();
    Integer count();

}
