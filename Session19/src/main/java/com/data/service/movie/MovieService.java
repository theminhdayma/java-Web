package com.data.service.movie;

import com.data.entity.Movie;

import java.util.List;

public interface MovieService{
    List<Movie> findAll();
    Movie findById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void deleteById(Long id);
}
