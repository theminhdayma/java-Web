package com.data.controller;

import com.data.entity.User;
import com.data.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping
    public String user(
            @RequestParam(defaultValue = "1") int page,
            Model model){
        int size = 5;
        long totalItems = userService.count();
        long totalPages = (long) Math.ceil((double) totalItems / size);
        List<User> users = userService.findAll(page,size);
        model.addAttribute("users",users);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("page",page);
        return "user-list";
    }

    @PostMapping("/change-status")
    public String changeStatus(@RequestParam Long id, @RequestParam boolean status) {
        userService.changeStatus(id, status);
        return "redirect:/user";
    }
}
