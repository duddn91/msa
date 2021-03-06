package com.example.productservice.service;

import com.example.productservice.message.CancelOrderEvent;
import com.example.productservice.message.CreateOrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class KafkaConsumerService {

    @Bean
    public Consumer<CreateOrderEvent> decreaseProduct(ProductService productService) {
        return productService::decreaseProduct;
    }

    @Bean
    public Consumer<CancelOrderEvent> increaseProductByUser(ProductService productService) {
        return productService::increaseProductByUser;
    }

    @Bean
    public Consumer<CancelOrderEvent> increaseProductBySystem(ProductService productService) {
        return productService::increaseProductBySystem;
    }

}
