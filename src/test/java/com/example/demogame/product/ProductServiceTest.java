package com.example.demogame.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
class ProductServiceTest {
    @Autowired
    ProductService productService;
//    @BeforeEach
//
//    @AfterEach
//    @Autowired
//    public ProductServiceTest(ProductService productService){
//        this.productService=productService;
//    }

    @Test
    void getAllProducts() {
    }

    @Test
    void addProduct() {
        Product productToAdd= new Product("new product",34, "new product description");
        productService.addProduct(productToAdd);
    }

    @Test
    void getProductByName() {
        Product productToAdd= new Product("new product",34, "new product description");
        productService.addProduct(productToAdd);
        Product added = productService.getProductByName("new product");
        assertNotNull(added);
    }
}