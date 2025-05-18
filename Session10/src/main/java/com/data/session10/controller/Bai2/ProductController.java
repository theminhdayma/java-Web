package com.data.session10.controller.Bai2;

import com.data.session10.model.Bai2.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @GetMapping("/productForm")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "Bai2/productForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("product", product);
        return "Bai2/resultProduct";
    }
}

