package com.data.session10.controller.Bai1;

import com.data.session10.model.Bai1.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "Bai1/userForm";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "Bai1/result";
    }
}

