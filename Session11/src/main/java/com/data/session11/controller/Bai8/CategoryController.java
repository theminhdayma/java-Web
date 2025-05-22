package com.data.session11.controller.Bai8;

import com.data.session11.model.Bai8.Category;
import com.data.session11.service.Bai8.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    // Hiển thị danh sách category
    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", service.getAllCategory());
        return "Bai8/list";
    }

    // Hiển thị form sửa category
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Category category = service.findById(id);
        if (category == null) {
            model.addAttribute("error", "Không tìm thấy danh mục với ID: " + id);
            return "Bai8/error";
        }
        model.addAttribute("category", category);
        return "Bai8/edit";
    }

    // Xử lý cập nhật category
    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id,
                         @RequestParam("categoryName") String name,
                         @RequestParam(value = "status", required = false) Boolean status,
                         Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Tên danh mục không được để trống");
            return "Bai8/error";
        }

        // Kiểm tra tên bị trùng với danh mục khác (không phải chính nó)
        Category existing = service.findById(id);
        if (existing != null && !existing.getCategoryName().equalsIgnoreCase(name.trim())
                && service.isCategoryNameExists(name.trim())) {
            model.addAttribute("error", "Tên danh mục đã tồn tại!");
            return "Bai8/error";
        }

        Category category = new Category(id, name.trim(), status != null && status);
        boolean updated = service.updateCategory(category);
        if (!updated) {
            model.addAttribute("error", "Cập nhật danh mục thất bại");
            return "Bai8/error";
        }
        return "redirect:/category";
    }

    // Hiển thị form thêm mới category
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("category", new Category());
        return "Bai8/edit";
    }

    // Xử lý thêm mới category
    @PostMapping("/save")
    public String save(@RequestParam("categoryName") String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Tên danh mục không được để trống");
            return "Bai8/error";
        }

        if (service.isCategoryNameExists(name.trim())) {
            model.addAttribute("error", "Tên danh mục đã tồn tại!");
            return "Bai8/error";
        }

        boolean added = service.addCategory(new Category(null, name.trim(), true));
        if (!added) {
            model.addAttribute("error", "Thêm danh mục thất bại");
            return "Bai8/error";
        }
        return "redirect:/category";
    }

    // Xóa category
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        boolean deleted = service.deleteCategory(id);
        if (!deleted) {
            model.addAttribute("error", "Không thể xóa danh mục ID: " + id);
            return "Bai8/error";
        }
        return "redirect:/category";
    }
}
