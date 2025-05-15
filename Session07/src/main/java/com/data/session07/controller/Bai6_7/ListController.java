package com.data.session07.controller.Bai6_7;

import com.data.session07.model.Bai6.CartItem;
import com.data.session07.model.Bai6.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ListController {

    private List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Tai nghe Bluetooth", 120.0, 50, "Tai nghe không dây âm thanh chất lượng cao", "https://via.placeholder.com/150"));
        products.add(new Product(2, "Chuột không dây", 35.0, 40, "Chuột không dây tiện lợi cho laptop và PC", "https://via.placeholder.com/150"));
        products.add(new Product(3, "Bàn phím cơ", 90.0, 30, "Bàn phím cơ với đèn LED RGB", "https://via.placeholder.com/150"));
        products.add(new Product(4, "Màn hình 24 inch", 200.0, 20, "Màn hình Full HD 24 inch", "https://via.placeholder.com/150"));
        products.add(new Product(5, "Ổ cứng SSD 512GB", 150.0, 35, "Ổ cứng thể rắn SSD tốc độ cao 512GB", "https://via.placeholder.com/150"));

        return products;
    }

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", getProductList());
        return "Bai6_7/productList";
    }

    @GetMapping("/products/details")
    public String showProductDetails(@RequestParam("id") int id, Model model) {
        Product selected = getProductList().stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);

        if (selected != null) {
            model.addAttribute("product", selected);
            return "Bai6_7/productDetail";
        } else {
            return "redirect:/products";
        }
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("id") int id,
                            @RequestParam("quantity") int quantity,
                            HttpSession session,
                            Model model) {
        if (quantity <= 0) {
            model.addAttribute("error", "Số lượng phải lớn hơn 0");
            model.addAttribute("products", getProductList());
            return "Bai6_7/productList";
        }

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        Product product = getProductList().stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);

        if (product != null) {
            Optional<CartItem> existing = cart.stream()
                    .filter(item -> item.getProduct().getId() == id)
                    .findFirst();

            if (existing.isPresent()) {
                existing.get().setQuantity(existing.get().getQuantity() + quantity);
            } else {
                cart.add(new CartItem(product, quantity));
            }
        }

        session.setAttribute("cart", cart);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "Bai6_7/cart";
    }

    @GetMapping("/cart/increase")
    public String increaseQuantity(@RequestParam("id") int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/decrease")
    public String decreaseQuantity(@RequestParam("id") int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() - 1);
                    if (item.getQuantity() <= 0) {
                        iterator.remove();
                    }
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("id") int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId() == id);
        }
        return "redirect:/cart";
    }
}

