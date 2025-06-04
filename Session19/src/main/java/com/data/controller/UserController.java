package com.data.controller;

import com.data.entity.User;
import com.data.service.CloudinaryService;
import com.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("user")
    public String users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("add-user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult result) throws IOException {
        if (user.getFirstName().length() < 3 || user.getLastName().length() > 10) {
            result.rejectValue("firstName", "error.firstName", "Họ không hợp lệ!");
        }

        if (user.getLastName().length() < 3 || user.getLastName().length() > 10) {
            result.rejectValue("lastName", "error.lastName", "Tên không hợp lệ!");
        }

        if (user.getFile() == null || user.getFile().isEmpty()) {
            result.rejectValue("file", "error.file", "Vui lòng chọn hình ảnh");
        }

        if (result.hasErrors()){
            return "add-user";
        }

        String URL = cloudinaryService.uploadFile(user.getFile());
        user.setFileImage(URL);
        userService.addUser(user);
        return "redirect:/user";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
