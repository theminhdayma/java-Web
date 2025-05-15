package com.data.session09.dao;

import com.data.session09.model.Schedule;

import java.util.List;

public interface ScheduleDAO {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}

