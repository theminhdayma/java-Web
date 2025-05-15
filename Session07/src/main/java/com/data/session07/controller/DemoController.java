package com.data.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @RequestMapping(value = "demos", method = RequestMethod.GET)
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView("demo");
        return mav;
    }
}
