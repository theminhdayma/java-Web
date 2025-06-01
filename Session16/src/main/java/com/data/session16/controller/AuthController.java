package com.data.session16.controller;

import com.data.session16.dto.UserDto;
import com.data.session16.model.Role;
import com.data.session16.model.User;
import com.data.session16.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("user") UserDto userDto,
                                 BindingResult result, Model model) {
        if (authService.userExists(userDto.getUsername())) {
            result.rejectValue("username", "error.user", "Username đã tồn tại!");
        }

        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        boolean success = authService.registerUser(user);
        if (success) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Đăng ký thất bại. Vui lòng thử lại!");
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        if (authService.login(username, password)) {
            User user = authService.getUserByUsername(username);
            if (Role.ADMIN.equals(user.getRole())) {
                return "redirect:/listBus";
            } else if (Role.USER.equals(user.getRole())) {
                return "redirect:/home";
            }
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }
}
