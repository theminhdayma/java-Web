package com.data.controller;

import com.data.entity.Product;
import com.data.entity.ProductCart;
import com.data.service.CartService;
import com.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("productId") Integer productId, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        ProductCart existing = cartService.findByCustomerIdAndProductId(customerId, productId);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
            cartService.update(existing);
        } else {
            ProductCart newCart = new ProductCart();
            newCart.setCustomerId(customerId);
            newCart.setProductId(productId);
            newCart.setQuantity(1);
            cartService.save(newCart);
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        List<ProductCart> cartItems = cartService.findByCustomerId(customerId);
        double total = 0.0;

        for (ProductCart item : cartItems) {
            Product product = productService.findById(item.getProductId());
            total += product.getPrice() * item.getQuantity();
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);

        return "cart";
    }

}
