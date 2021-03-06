package com.example.productservice;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
@EnableJpaAuditing
public class ProductServiceApplication implements ApplicationRunner {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ProductEntity product1 = ProductEntity.builder()
                .productId("Apple Macbook")
                .productName("맥북")
                .stock(999)
                .price(200_0000)
                .build();

        ProductEntity product2 = ProductEntity.builder()
                .productId("Samsung Galaxy")
                .productName("갤럭시")
                .stock(99)
                .price(150_0000)
                .build();

        ProductEntity product3 = ProductEntity.builder()
                .productId("Lg Gram")
                .productName("그램")
                .stock(9)
                .price(100_0000)
                .build();

        productRepository.saveAll(Arrays.asList(product1, product2, product3));
    }

}
