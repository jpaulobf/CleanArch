package com.example.demo.clean.domains.entities;

public record Produto(Integer id, 
                      String nome, 
                      String descricao,
                      Integer quantidade,
                      Double preco) {
}
