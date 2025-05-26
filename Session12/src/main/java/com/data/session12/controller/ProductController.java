package com.data.session12.controller;

import com.data.session12.dto.ProductDto;
import com.data.session12.model.Product;
import com.data.session12.model.Status;
import com.data.session12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final String UPLOAD_DIR = "C:/Rekkei-Academy/BE-CTDL-GT/java-Web/Session12/src/main/webapp/uploads";

    @Autowired
    private ProductService productService;

    // Hiển thị danh sách sản phẩm
    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/search")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productService.searchProducts(keyword);
        model.addAttribute("products", products);
        return "list";
    }

    // Hiển thị form thêm sản phẩm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("statusList", Status.values());
        return "add";
    }

    // Xử lý thêm sản phẩm
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("productDto") ProductDto productDto,
                             BindingResult result,
                             Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("statusList", Status.values());
            return "add";
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = saveFile(productDto.getImage());
        Product product = convertProductDtoToProduct(productDto, fileName);
        productService.addProduct(product);

        return "redirect:/product/list";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/product/list";
        }

        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setStatus(product.getStatus());

        model.addAttribute("productDto", dto);
        model.addAttribute("statusList", Status.values());
        model.addAttribute("productId", id);
        return "edit";
    }

    // Xử lý chỉnh sửa sản phẩm
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id,
                              @Valid @ModelAttribute("productDto") ProductDto dto,
                              BindingResult result,
                              Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("statusList", Status.values());
            model.addAttribute("productId", id);
            return "edit";
        }

        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/product/list";
        }

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setStatus(dto.getStatus());

        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            String fileName = saveFile(dto.getImage());
            product.setImage(fileName);
        }

        productService.updateProduct(product);
        return "redirect:/product/list";
    }

    // Xử lý xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    // Chuyển đổi từ ProductDto sang Product
    private Product convertProductDtoToProduct(ProductDto dto, String fileName) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setStatus(dto.getStatus());
        product.setImage(fileName);
        product.setCreatedAt(LocalDateTime.now());
        return product;
    }

    // Lưu ảnh vào thư mục uploads và trả về đường dẫn tương đối
    private String saveFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String ext = originalName.substring(originalName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + ext;

        File destination = new File(UPLOAD_DIR, newFileName);
        file.transferTo(destination);

        return "uploads/" + newFileName;
    }
}
