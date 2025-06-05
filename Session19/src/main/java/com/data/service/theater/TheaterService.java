package com.data.service.theater;

import com.data.entity.Theater;

import java.util.List;

public interface TheaterService{
    List<Theater> findAll();
    Theater findById(Long theaterId);
    void save(Theater theater);
    void delete(Long id);
}
