package com.data.session09.service;

import com.data.session09.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}
