package com.example.demo.mvc.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.mvc.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
