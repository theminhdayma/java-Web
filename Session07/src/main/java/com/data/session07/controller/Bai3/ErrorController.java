package com.data.session07.controller.Bai3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("Bai3/error");
        return mav;
    }
}
