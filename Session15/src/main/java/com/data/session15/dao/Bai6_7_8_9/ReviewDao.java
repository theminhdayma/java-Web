package com.data.session15.dao.Bai6_7_8_9;

import com.data.session15.model.Bai6_7_8_9.*;

import java.util.List;

public interface ReviewDao {
    boolean addReview(Review review);
    List<Product> getAllProducts();
    List<Review> getReviewsByProductId(int productId);
    Product getProductById(int id);
    boolean addToCart(Cart cart);
    List<Cart> getCartByUserId(int userId);
    boolean addOrder(Orders orders);
}
