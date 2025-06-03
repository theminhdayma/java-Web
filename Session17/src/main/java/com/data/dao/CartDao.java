package com.data.dao;

import com.data.entity.ProductCart;

import java.util.List;

public interface CartDao {
    ProductCart findByCustomerIdAndProductId(int customerId, int productId);
    void save(ProductCart productCart);
    void update(ProductCart productCart);
    List<ProductCart> findByCustomerId(int customerId);
}
