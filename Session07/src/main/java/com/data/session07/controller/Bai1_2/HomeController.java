package com.data.session07.controller.Bai1_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/homes")
public class HomeController {

    @GetMapping
    public ModelAndView home(@RequestParam String name) {
        ModelAndView mav = new ModelAndView("Bai1_2/home");
        mav.addObject("message", "Hello, " + name + "!");
        return mav;
    }
}
