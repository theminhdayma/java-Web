package com.data.session08.repository.Bai2;

import com.data.session08.model.Bai2.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
