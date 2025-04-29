package com.example.demo.clean.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.clean.application.gateways.ProdutoGateway;
import com.example.demo.clean.application.usecases.ProdutoIteractor;
import com.example.demo.clean.application.usecases.ProdutoUseCase;
import com.example.demo.clean.infrastructure.gateways.ProdutoGatewayImpl;
import com.example.demo.clean.infrastructure.persistence.ProdutoPersistence;

@Configuration
public class ProdutoConfigurator {

    @Bean
    public ProdutoIteractor produtoIteractor(ProdutoGateway produtoGateway) {
        return new ProdutoUseCase(produtoGateway);
    }

    @Bean
    public ProdutoGateway produtoGateway(ProdutoPersistence produtoPersistence) {
        return new ProdutoGatewayImpl(produtoPersistence);
    }
}