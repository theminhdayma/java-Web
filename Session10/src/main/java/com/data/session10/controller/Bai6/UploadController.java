package com.data.session10.controller.Bai6;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session10.model.Bai6.UploadFile;
import com.data.session10.service.Bai6.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private UploadService uploadService;

    @GetMapping("/uploadFormCloud")
    public String showForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "Bai6/uploadForm";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@ModelAttribute("uploadFile") UploadFile uploadFile, Model model) {
        MultipartFile file = uploadFile.getFile();

        if (file != null && !file.isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                        ObjectUtils.emptyMap());

                String fileUrl = (String) uploadResult.get("url");
                if (fileUrl == null || fileUrl.isEmpty()) {
                    throw new RuntimeException("Không thể lấy URL tệp từ Cloudinary.");
                }
                uploadFile.setFileUrl(fileUrl);

                uploadService.save(uploadFile);

                model.addAttribute("message", "Tải lên thành công!");
                model.addAttribute("fileUrl", fileUrl);
                model.addAttribute("description", uploadFile.getDescription());

            } catch (IOException e) {
                model.addAttribute("message", "Lỗi khi tải lên: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn tệp.");
        }

        return "Bai6/uploadResult";
    }
}
