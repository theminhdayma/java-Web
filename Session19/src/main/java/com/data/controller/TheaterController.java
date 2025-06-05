package com.data.controller;

import com.data.entity.Theater;
import com.data.service.theater.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/theater")
public class TheaterController{

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public String theaterList(Model model){
        model.addAttribute("theaters", theaterService.findAll());
        return "theater/theater-list";
    }

    @GetMapping("form")
    public String theaterForm(@RequestParam(required = false) Long id, Model model){
        if (id == null) {
            model.addAttribute("theater", new Theater());
            return "theater/theater-form";
        }
        Theater theater = theaterService.findById(id);
        if(theater == null){
            return "redirect:/theater";
        }
        model.addAttribute("theater", theater);
        return "theater/theater-form";
    }

    @GetMapping("/delete/{id}")
    public String theaterDelete(@PathVariable Long id, Model model){
        Theater theater = theaterService.findById(id);
        if(theater == null){
            return "redirect:/theater";
        }
        theaterService.delete(id);
        return "redirect:/theater";
    }

    @PostMapping("form")
    public String theaterAction(@Valid @ModelAttribute Theater theater,
                                BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "theater/theater-form";
        }
        theaterService.save(theater);
        return "redirect:/theater";
    }
}
