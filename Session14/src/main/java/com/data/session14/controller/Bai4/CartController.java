package com.data.session14.controller.Bai4;

import com.data.session14.model.Bai4.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
public class CartController {

    @GetMapping("/form")
    public String showForm(Model model) {
        return "Bai4/form";
    }

    @PostMapping("/addCart")
    public String addToCart(
            @RequestParam String name,
            @RequestParam int quantity,
            HttpSession session,
            HttpServletResponse response,
            @CookieValue(value = "productNames", defaultValue = "") String productNamesCookie
    ) {
        // 1. Lưu vào session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        cart.add(new CartItem(name, quantity));
        session.setAttribute("cart", cart);

        // 2. Lưu vào cookie
        String cookieValue = productNamesCookie;
        if (!cookieValue.contains(name)) {
            cookieValue = cookieValue.isEmpty() ? name : cookieValue + "|" + name;
        }
        Cookie cookie = new Cookie("productNames", URLEncoder.encode(cookieValue, StandardCharsets.UTF_8));
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
        response.addCookie(cookie);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String showCart(
            HttpSession session,
            Model model,
            @CookieValue(value = "productNames", defaultValue = "") String productNamesCookie
    ) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        model.addAttribute("cart", cart);

        List<String> productsFromCookie = new ArrayList<>();
        if (!productNamesCookie.isEmpty()) {
            String decoded = URLDecoder.decode(productNamesCookie, StandardCharsets.UTF_8);
            productsFromCookie = Arrays.asList(decoded.split("\\|"));
        }
        model.addAttribute("productsFromCookie", productsFromCookie);

        return "Bai4/cart";
    }

    @GetMapping("/remove")
    public String removeItem(@RequestParam int index, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null && index >= 0 && index < cart.size()) {
            cart.remove(index);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }
}

