package com.data.session08.controller.Bai1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("Bai1/welcome");
        mav.addObject("message", "Chào mừng đến với ứng dụng của chúng tôi!");
        return mav;
    }
}
