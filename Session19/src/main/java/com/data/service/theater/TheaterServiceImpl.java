package com.data.service.theater;

import com.data.entity.Theater;
import com.data.dao.theater.TheaterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService{
    @Autowired
    private TheaterDao theaterRepo;

    @Override
    public List<Theater> findAll(){
        return theaterRepo.findAll();
    }

    @Override
    public Theater findById(Long theaterId){
        return theaterRepo.findById(theaterId);
    }

    @Override
    public void save(Theater theater){
        theaterRepo.save(theater);
    }

    @Override
    public void delete(Long id){
        theaterRepo.delete(id);
    }
}
