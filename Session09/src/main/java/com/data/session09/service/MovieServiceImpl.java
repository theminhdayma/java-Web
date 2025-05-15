package com.data.session09.service;
import com.data.session09.dao.MovieDAO;
import com.data.session09.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
}
