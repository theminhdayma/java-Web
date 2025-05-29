package com.data.session15.service.Bai6_7_8_9;

import com.data.session15.model.Bai6_7_8_9.*;

import java.util.List;

public interface ReviewService {
    boolean addReview(Review review);
    List<Product> getAllProducts();
    List<Review> getReviewsByProductId(int productId);
    Product getProductById(int id);
    boolean addToCart(Cart cart);
    List<Cart> getCartByUserId(int userId);
    boolean addOrder(Orders orders);
}
