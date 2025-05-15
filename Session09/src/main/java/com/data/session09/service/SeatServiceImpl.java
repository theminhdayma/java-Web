package com.data.session09.service;

import com.data.session09.dao.SeatDAO;
import com.data.session09.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDAO seatDAO;

    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        return seatDAO.getSeatsByScreenRoom(screenRoomId);
    }

    @Override
    public List<Long> getBookedSeatsBySchedule(Long scheduleId) {
        return seatDAO.getBookedSeatsBySchedule(scheduleId);
    }
}
