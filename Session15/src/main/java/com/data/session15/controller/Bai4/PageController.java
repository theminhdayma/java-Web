package com.data.session15.controller.Bai4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String home() {
        return "Bai4/home";
    }

    @GetMapping("/about")
    public String about() {
        return "Bai4/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Bai4/contact";
    }
}
