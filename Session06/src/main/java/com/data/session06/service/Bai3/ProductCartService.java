package com.data.session06.service.Bai3;

import com.data.session06.model.Bai3.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> findCartByUserId(int userId);
    boolean removeProductFromCart(int userId, int productId);
}
