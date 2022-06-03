package com.example.demogame.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/insert")
    public ResponseEntity addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping()
    public ResponseEntity getProduct(@RequestParam String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }
}
