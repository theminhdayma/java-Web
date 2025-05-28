package com.data.session14.controller.Bai6;

import com.data.session14.model.Bai6.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final List<User> users = new ArrayList<>();

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "Bai6/register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           HttpServletRequest request,
                           Model model) {
        Locale locale = localeResolver.resolveLocale(request);

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "user.confirmPassword.mismatch");
        }

        if (usernameExists(user.getUsername())) {
            bindingResult.rejectValue("username", "user.username.exists");
        }

        if (bindingResult.hasErrors()) {
            return "Bai6/register";
        }

        saveUser(user);

        model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
        return "Bai6/success";
    }

    private void saveUser(User user) {
        users.add(user);
    }

    private boolean usernameExists(String username) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
    }
}
