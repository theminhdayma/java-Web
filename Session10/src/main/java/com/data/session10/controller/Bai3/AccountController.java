package com.data.session10.controller.Bai3;

import com.data.session10.model.Bai3.Account;
import com.data.session10.service.Bai3.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/registerForm")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "Bai3/registerForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("account") Account account, Model model) {
        accountService.save(account);
        model.addAttribute("message", "Đăng ký thành công!");
        return "Bai3/registerSuccess";
    }
}

