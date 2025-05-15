package com.data.session07.controller.Bai4;

import com.data.session07.model.Bai4.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    private final List<Feedback> feedbackList = new ArrayList<>();

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "Bai4/form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("feedback") Feedback feedback, Model model) {
        List<String> errors = new ArrayList<>();

        if (feedback.getName() == null || feedback.getName().isEmpty()) {
            errors.add("Họ và tên không được để trống.");
        }
        if (feedback.getPhone() == null || !feedback.getPhone().matches("\\d{9,11}")) {
            errors.add("Số điện thoại không hợp lệ (chỉ chứa số và 9-11 ký tự).");
        }
        if (feedback.getContent() == null || feedback.getContent().isEmpty()) {
            errors.add("Nội dung góp ý không được để trống.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "Bai4/form";
        }

        feedbackList.add(feedback);
        model.addAttribute("feedback", feedback);
        return "Bai4/result";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("feedbackList", feedbackList);
        return "Bai4/list";
    }
}