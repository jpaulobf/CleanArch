package com.example.demo.clean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoPersistence extends JpaRepository<ProdutoEntity, Integer> {
}