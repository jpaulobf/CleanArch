package com.example.demo.clean.infrastructure.controller;

import com.example.demo.clean.application.usecases.ProdutoIteractor;
import com.example.demo.clean.domains.entities.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v2/produto")
public class ProdutoController {

    private final ProdutoIteractor produtoIteractor;

    public ProdutoController(ProdutoIteractor produtoIteractor) {
        this.produtoIteractor = produtoIteractor;
    }

    @GetMapping({"/", ""})
    public List<Produto> findAllProducts() {
        return this.produtoIteractor.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoIteractor.getProdutoById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return this.produtoIteractor.saveProduto(produto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return this.produtoIteractor.deleteProduto(id);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return this.produtoIteractor.deleteAllProdutos();
    }

    @GetMapping("/count")
    public Integer count() {
        return this.produtoIteractor.countProdutos();
    }
}
