package com.info3.s2g2.service.impl;

import com.info3.s2g2.model.Product;
import com.info3.s2g2.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {

        return products;
    }

    @Override
    public Boolean save(Product product) {
        products.add(product);
        System.out.println(product.toString());
        return true;
    }
}
