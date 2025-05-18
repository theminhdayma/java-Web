package com.data.session10.controller.Bai5;

import com.data.session10.model.Bai5.Document;
import com.data.session10.service.Bai5.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class DocumentController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documentForm")
    public String showForm(Model model) {
        model.addAttribute("document", new Document());
        return "Bai5/documentForm";
    }

    @PostMapping("/uploadDocument")
    public String uploadDocument(@ModelAttribute("document") Document document, Model model) {
        MultipartFile file = document.getFileName();

        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            String uploadDir = servletContext.getRealPath("/docs/");
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try {
                file.transferTo(new File(uploadDir + fileName));
                model.addAttribute("message", "Tải lên thành công!");
                model.addAttribute("title", document.getTitle());
                model.addAttribute("description", document.getDescription());
                model.addAttribute("fileName", fileName);
            } catch (IOException e) {
                model.addAttribute("message", "Lỗi khi tải lên: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn file PDF.");
        }

        return "Bai5/documentResult";
    }
}

