package com.example.demo.clean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.application.usecases.ProdutoIteractor;
import com.example.demo.clean.application.usecases.ProdutoUseCase;
import com.example.demo.clean.infrastructure.gateways.ProdutoGatewayImpl;
import com.example.demo.clean.infrastructure.persistence.ProdutoPersistence;

@Configuration
public class ProdutoConfig {
  
    @Bean
    public ProdutoUseCase produtoUseCase(ProdutoGateway produtoGateway) {
        return new ProdutoIteractor(produtoGateway);
    }

    @Bean 
    public ProdutoGateway produtoGateway(ProdutoPersistence produtoRepository) {
        return new ProdutoGatewayImpl(produtoRepository);
    }

}
