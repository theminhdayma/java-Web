package com.data.session06.dao.Bai3;

import com.data.session06.model.Bai3.ProductCart;

import java.util.List;

public interface ProductCartDao {
    List<ProductCart> findCartByUserId(int userId);
    boolean removeProductFromCart(int userId, int productId);
}
