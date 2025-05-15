package com.data.session03.bai10;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : cart) {
            if (p.getId() == product.getId()) {
                return; // Đã tồn tại
            }
        }
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void removeProduct(int id) {
        cart.removeIf(p -> p.getId() == id);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }
}

