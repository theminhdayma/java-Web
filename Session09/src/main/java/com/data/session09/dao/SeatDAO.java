package com.data.session09.dao;

import com.data.session09.model.Seat;

import java.util.List;

public interface SeatDAO {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}

