package com.data.session15.controller.Bai6_7_8_9;

import com.data.session15.dto.CartDto;
import com.data.session15.model.Bai6_7_8_9.Cart;
import com.data.session15.model.Bai6_7_8_9.Orders;
import com.data.session15.model.Bai6_7_8_9.Product;
import com.data.session15.model.Bai6_7_8_9.Review;
import com.data.session15.service.Bai6_7_8_9.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> productList = reviewService.getAllProducts();
        model.addAttribute("products", productList);
        return "Bai6_7_8_9/listProduct";
    }

    @GetMapping("/detail/{id}")
    public String viewProductDetail(@PathVariable("id") int id, Model model) {
        Product product = reviewService.getProductById(id);
        List<Review> reviews = reviewService.getReviewsByProductId(id);

        Review newReview = new Review();
        newReview.setProductId(id);

        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        model.addAttribute("newReview", newReview);

        return "Bai6_7_8_9/productDetail";
    }

    @PostMapping("/review")
    public String addReview(@ModelAttribute("newReview") Review review) {
        review.setUserId(1);
        reviewService.addReview(review);
        return "redirect:/product/detail/" + review.getProductId();
    }

    @GetMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable("productId") int productId) {
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setUserId(1);
        cart.setQuantity(1);
        reviewService.addToCart(cart);
        return "redirect:/product/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        int userId = 1;
        List<Cart> cartItems = reviewService.getCartByUserId(userId);
        List<CartDto> cartResponses = new ArrayList<>();
        double total = 0;

        for (Cart c : cartItems) {
            Product product = reviewService.getProductById(c.getProductId());
            if (product != null) {
                double itemTotal = product.getPrice() * c.getQuantity();
                CartDto response = new CartDto(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        c.getQuantity(),
                        itemTotal
                );
                cartResponses.add(response);
                total += itemTotal;
            }
        }


        model.addAttribute("cartItems", cartResponses);
        model.addAttribute("total", total);
        return "Bai6_7_8_9/cart";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        int userId = 1;
        List<Cart> cartItems = reviewService.getCartByUserId(userId);
        List<CartDto> cartDtos = new ArrayList<>();

        double total = 0;
        for (Cart c : cartItems) {
            Product product = reviewService.getProductById(c.getProductId());
            if (product != null) {
                double itemTotal = product.getPrice() * c.getQuantity();
                cartDtos.add(new CartDto(product.getId(), product.getName(), product.getPrice(), c.getQuantity(), itemTotal));
                total += itemTotal;
            }
        }

        model.addAttribute("cartItems", cartDtos);
        model.addAttribute("total", total);
        return "Bai6_7_8_9/checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@RequestParam String recipientName,
                                  @RequestParam String address,
                                  @RequestParam String phoneNumber) {
        Orders order = new Orders();
        order.setUserId(1);
        order.setRecipientName(recipientName);
        order.setAddress(address);
        order.setPhoneNumber(phoneNumber);

        boolean success = reviewService.addOrder(order);

        if (success) {
            return "redirect:/product/cart";
        } else {
            return "redirect:/product/checkout";
        }
    }

}
