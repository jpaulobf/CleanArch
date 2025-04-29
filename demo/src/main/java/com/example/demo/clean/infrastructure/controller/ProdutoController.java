package com.example.demo.clean.infrastructure.controller;

import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.entities.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v2/produto")
public class ProdutoController {

    private final ProdutoGateway produtoGateway;

    public ProdutoController(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @GetMapping({"/", ""})
    public List<Produto> findAllProducts() {
        return this.produtoGateway.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoGateway.findById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return this.produtoGateway.save(produto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return this.produtoGateway.deleteById(id);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return this.produtoGateway.deleteAll();
    }

    @GetMapping("/count")
    public Integer count() {
        return this.produtoGateway.count();
    }
}
