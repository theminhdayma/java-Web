package com.data.session10.controller.Bai10;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session10.model.Bai10.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductManagementController {

    private static List<Product> productList = new ArrayList<>();
    private static int currentId = 1;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "Bai10/productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("file") MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");
            product.setImage(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            product.setImage("");
        }

        product.setId(currentId++);
        productList.add(product);

        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (product == null) {
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "Bai10/productForm";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,
                                @RequestParam("file") MultipartFile file) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setStock(product.getStock());

                if (file != null && !file.isEmpty()) {
                    try {
                        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                        String imageUrl = (String) uploadResult.get("secure_url");
                        p.setImage(imageUrl);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;
            }
        }
        return "redirect:/product/list";
    }


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("productList", productList);
        return "Bai10/productList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productList.removeIf(p -> p.getId() == id);
        return "redirect:/product/list";
    }
}

