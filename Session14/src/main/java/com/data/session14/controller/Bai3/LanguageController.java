package com.data.session14.controller.Bai3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class LanguageController {

    @GetMapping("/home")
    public String home(@CookieValue(name = "lang", defaultValue = "en") String lang, Model model) {
        Locale locale = new Locale(lang);
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        model.addAttribute("title", bundle.getString("title"));
        model.addAttribute("description", bundle.getString("description"));
        model.addAttribute("languageSelect", bundle.getString("language.select"));
        model.addAttribute("selectedLang", lang);

        return "Bai3/home";
    }

    @PostMapping("/change-language")
    public String changeLanguage(@RequestParam("lang") String lang, HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        return "redirect:/home";
    }
}

