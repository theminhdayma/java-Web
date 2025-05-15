package com.data.session09.service;

import com.data.session09.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}
