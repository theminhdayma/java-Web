package com.data.session12.dao;

import com.data.session12.model.Product;

import java.util.List;

public interface ProductDao {
    boolean addProduct(Product product);
    Product getProductById(int id);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> getAllProducts();
    List<Product> searchProducts(String productName);
}
