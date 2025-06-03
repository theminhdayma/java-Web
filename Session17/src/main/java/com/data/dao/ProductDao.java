package com.data.dao;

import com.data.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll(int page, int size);
    Product findById(int id);
    long countAll ();
}
