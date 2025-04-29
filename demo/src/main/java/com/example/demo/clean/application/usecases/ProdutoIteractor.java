package com.example.demo.clean.application.usecases;

import java.util.List;
import com.example.demo.clean.domains.entities.Produto;

public interface ProdutoIteractor {
   
    public List<Produto> getAllProdutos();

    public Produto getProdutoById(int id);

    public Produto saveProduto(Produto produto);

    public boolean deleteProduto(int id);

    public boolean deleteAllProdutos();

    public Integer countProdutos();
    
}