package com.data.session06.service.Bai3;

import com.data.session06.model.Bai3.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean addProductToCart(int userId, int productId, int quantity);
}
