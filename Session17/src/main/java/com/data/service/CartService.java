package com.data.service;

import com.data.entity.ProductCart;

import java.util.List;

public interface CartService {
    ProductCart findByCustomerIdAndProductId(int customerId, int productId);
    void save(ProductCart productCart);
    void update(ProductCart productCart);
    List<ProductCart> findByCustomerId(int customerId);

}
