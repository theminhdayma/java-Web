package com.data.service;

import com.data.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(int page, int size);
    Product findById(int id);
    long countAll();
    List<Product> getAllProduct();
    List<Product> filterProductByPrice(double minPrice, double maxPrice);
}
