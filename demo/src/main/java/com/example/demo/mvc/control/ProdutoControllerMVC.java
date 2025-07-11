package com.example.demo.mvc.control;

import com.example.demo.mvc.model.entities.Produto;
import com.example.demo.mvc.model.services.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/produto")
public class ProdutoControllerMVC {

    private final ProdutoService produtoService;

    public ProdutoControllerMVC(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping({"/", ""})
    public List<Produto> findAllProducts() {
        return this.produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoService.findById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return this.produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return this.produtoService.deleteById(id);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return this.produtoService.deleteAll();
    }

    @GetMapping("/count")
    public Integer count() {
        return this.produtoService.count();
    }
}
