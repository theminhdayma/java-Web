package com.data.session11.controller.Bai7;


import com.data.session11.model.Bai7.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("review", new Review());
        return "Bai7/reviewForm";
    }

    @PostMapping("/review")
    public String submitReview(
            @Valid @ModelAttribute("reviewForm") Review form,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "Bai7/reviewForm";
        }
        return "Bai7/result";
    }
}


