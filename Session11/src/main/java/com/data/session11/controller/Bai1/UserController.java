package com.data.session11.controller.Bai1;

import com.data.session11.model.Bai1.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "Bai1/userForm";
    }

    @PostMapping("/save")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Bai1/userForm";
        }
        return "Bai1/result";
    }
}

