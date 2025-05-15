package com.data.session08.controller.Bai2;

import com.data.session08.model.Bai2.Product;
import com.data.session08.service.Bai2.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("productList", products);
        return "Bai2/listProduct";
    }
}
