package com.data.session15.controller.Bai5;

import com.data.session15.model.Bai5.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductBai5Controller {

    private final List<Product> products = Arrays.asList(
            new Product("P001", "T-Shirt"),
            new Product("P002", "Jeans"),
            new Product("P003", "Jacket"),
            new Product("P004", "Sneakers")
    );

    @GetMapping("/search")
    public String showSearchPage() {
        return "Bai5/search";
    }

    @PostMapping("/search")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("error", "Trường tìm kiếm không được để trống.");
            return "Bai5/search";
        }

        List<Product> result = products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        p.getCode().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("products", result);
        model.addAttribute("keyword", keyword);
        return "Bai5/search";
    }
}

