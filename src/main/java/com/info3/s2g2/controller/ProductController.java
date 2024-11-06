package com.info3.s2g2.controller;

import com.info3.s2g2.model.Product;
import com.info3.s2g2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }
    @PostMapping
    public Boolean createProduct(@RequestBody Product product){
        return productService.save(product);
    }
}

