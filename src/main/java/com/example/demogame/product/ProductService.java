package com.example.demogame.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductByName(String productName){
//        Map<String, Object> query = new HashMap<>();
//        query.put("name", productName);
//        Product p = new Product("x",3,"");
        return productRepository.findByName(productName);
    }
}
