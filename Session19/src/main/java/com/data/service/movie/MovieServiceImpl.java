package com.data.service.movie;

import com.data.entity.Movie;
import com.data.dao.movie.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDao movieRepo;

    @Override
    public List<Movie> findAll(){
        return movieRepo.findAll();
    }

    @Override
    public Movie findById(Long id){
        return movieRepo.findById(id);
    }

    @Override
    public void save(Movie movie){
        movieRepo.save(movie);
    }

    @Override
    public void update(Movie movie){
         movieRepo.update(movie);
    }

    @Override
    public void deleteById(Long id){
        movieRepo.deleteById(id);
    }
}
