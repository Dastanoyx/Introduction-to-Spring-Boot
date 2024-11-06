package com.info3.s2g2.service;

import com.info3.s2g2.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Boolean save(Product product);
}
