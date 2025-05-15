package com.data.session09.controller;

import com.data.session09.model.User;
import com.data.session09.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            session.setAttribute("loggedInUserId", user.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String email,
                                  Model model) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setRole("USER");
        newUser.setEnabled(true);

        userService.register(newUser);

        model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
