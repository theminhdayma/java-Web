package com.data.session10.controller.Bai4;

import com.data.session10.model.Bai4.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/uploadForm")
    public String showForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "Bai4/uploadForm";
    }

    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile avatarFile = userProfile.getAvatar();
        String username = userProfile.getUsername();

        if (avatarFile != null && !avatarFile.isEmpty()) {
            String fileName = avatarFile.getOriginalFilename();
            long fileSize = avatarFile.getSize();

            String uploadDir = servletContext.getRealPath("/uploads/");
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try {
                avatarFile.transferTo(new File(uploadDir + fileName));
                model.addAttribute("message", "Tải lên thành công: " + fileName + " (" + fileSize + " bytes)");
                model.addAttribute("username", username);
            } catch (IOException e) {
                model.addAttribute("message", "Lỗi khi tải lên tệp: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn tệp để tải lên.");
            model.addAttribute("username", username);
        }

        return "Bai4/uploadResult";
    }

}

