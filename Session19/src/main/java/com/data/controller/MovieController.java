package com.data.controller;

import com.data.entity.Movie;
import com.data.service.CloudinaryService;
import com.data.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/movies")
public class MovieController{
    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String showMovie(Model model){
        model.addAttribute("movies", movieService.findAll());
        return "movie/movie-list";
    }

    @GetMapping("/form")
    public String showMovieForm(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("movie", new Movie());
            model.addAttribute("actionUrl", "/movies/form");
            return "movie/movie-form";
        }

        Movie movie = movieService.findById(id);
        if (movie == null) {
            return "redirect:/movies";
        }

        model.addAttribute("movie", movie);
        model.addAttribute("actionUrl", "/movies/form");

        return "movie/movie-form";
    }


    @PostMapping("/form")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie,
                            @RequestParam("file") MultipartFile file,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            return "movie/movie-form";
        }

        if (!file.isEmpty()) {
            try {
                String imageUrl = cloudinaryService.uploadFile(file);
                movie.setPoster(imageUrl);
            } catch (IOException e) {
                model.addAttribute("uploadError", "Lỗi upload ảnh!");
                return "movie/movie-form";
            }
        } else if (movie.getId() != null) {
            Movie existing = movieService.findById(movie.getId());
            if (existing != null) {
                movie.setPoster(existing.getPoster());
            }
        }

        movieService.save(movie);

        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, Model model) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        movieService.deleteById(id);
        return "redirect:/movies";
    }
}
