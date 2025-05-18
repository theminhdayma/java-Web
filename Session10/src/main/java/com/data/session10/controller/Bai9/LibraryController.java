package com.data.session10.controller.Bai9;

import com.data.session10.model.Bai9.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class LibraryController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/addBookForm")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "Bai9/bookForm";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        // Lưu file lên server
        MultipartFile file = book.getFile();
        if (file != null && !file.isEmpty()) {
            String uploadDir = servletContext.getRealPath("/uploads/");
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filename = file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadDir + filename));
            } catch (IOException e) {
                model.addAttribute("message", "Lỗi khi upload file: " + e.getMessage());
                return "Bai9/bookForm";
            }

            model.addAttribute("message", "Thêm sách thành công!");
        } else {
            model.addAttribute("message", "Vui lòng chọn file ebook!");
            return "Bai9/bookForm";
        }
        return "Bai9/bookList";
    }
}

