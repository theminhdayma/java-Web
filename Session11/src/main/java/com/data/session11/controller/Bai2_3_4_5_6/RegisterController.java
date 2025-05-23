package com.data.session11.controller.Bai2_3_4_5_6;

import com.data.session11.model.Bai2_3_4_5_6.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "Bai2/register"; // File JSP đăng ký
    }

    @PostMapping("/register")
    public String submitForm(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result); // Đưa lỗi xuống view
            return "Bai2/register";
        }
        return "Bai2/success"; // Thành công
    }
}
