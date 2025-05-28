package com.data.session14.controller.Bai2;

import com.data.session14.model.Bai2.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private static final String COOKIE_NAME = "productList";

    @GetMapping("/add")
    public String showForm() {
        return "Bai2/addProduct";
    }

    @PostMapping("/add")
    public String addProduct(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam double price,
            @CookieValue(value = COOKIE_NAME, defaultValue = "") String cookieData,
            HttpServletResponse response
    ) throws UnsupportedEncodingException {
        String newProduct = id + "," + name + "," + price;

        if (!cookieData.isEmpty()) {
            cookieData += "|" + newProduct;
        } else {
            cookieData = newProduct;
        }

        Cookie cookie = new Cookie(COOKIE_NAME, URLEncoder.encode(cookieData, StandardCharsets.UTF_8.toString()));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listProduct(
            Model model,
            @CookieValue(value = COOKIE_NAME, defaultValue = "") String cookieData
    ) throws UnsupportedEncodingException {
        List<Product> products = new ArrayList<>();

        if (!cookieData.isEmpty()) {
            String decoded = URLDecoder.decode(cookieData, StandardCharsets.UTF_8.toString());
            String[] items = decoded.split("\\|");
            for (String item : items) {
                String[] fields = item.split(",");
                if (fields.length == 3) {
                    try {
                        Product p = new Product(fields[0], fields[1], Double.parseDouble(fields[2]));
                        products.add(p);
                    } catch (NumberFormatException ignored) {}
                }
            }
        }

        model.addAttribute("products", products);
        return "Bai2/listProduct";
    }
}
