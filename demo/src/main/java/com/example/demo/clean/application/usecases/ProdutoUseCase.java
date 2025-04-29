package com.example.demo.clean.application.usecases;

import java.util.List;
import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.domains.entities.Produto;

/**
 * Serviço de Produto
 */
public class ProdutoUseCase implements ProdutoIteractor {
   
    private final ProdutoGateway produtoPersistenceGateway;

    /*
     * Construtor
     * Injeção de dependência do gateway de persistência de produtos
     */
    public ProdutoUseCase(ProdutoGateway produtoPersistenceGateway) {
        this.produtoPersistenceGateway = produtoPersistenceGateway;
    }    
    
    @Override
    public List<Produto> getAllProdutos() {
        return produtoPersistenceGateway.findAll();
    }

    @Override
    public Produto getProdutoById(int id) {
        return produtoPersistenceGateway.findById(id);
    }

    @Override
    public Produto saveProduto(Produto produto) {
        return produtoPersistenceGateway.save(produto);
    }

    @Override
    public boolean deleteProduto(int id) {
        return produtoPersistenceGateway.deleteById(id);
    }

    @Override
    public boolean deleteAllProdutos() {
        return produtoPersistenceGateway.deleteAll();
    }

    @Override
    public Integer countProdutos() {
        return produtoPersistenceGateway.count();
    }
}