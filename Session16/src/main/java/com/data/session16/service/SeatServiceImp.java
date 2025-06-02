package com.data.session16.service;

import com.data.session16.dao.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImp implements SeatService {

    @Autowired
    private SeatDao seatDao;
    @Override
    public boolean addSeat(int tripId, int seatNumber, String seatType) {
        return seatDao.addSeat(tripId, seatNumber, seatType);
    }

    @Override
    public boolean updateSeat(int tripId, int seatNumber, String seatType) {
        return seatDao.updateSeat(tripId, seatNumber, seatType);
    }

    @Override
    public boolean deleteSeat(int tripId, int seatNumber) {
        return  seatDao.deleteSeat(tripId, seatNumber);
    }

    @Override
    public boolean isSeatAvailable(int tripId, int seatNumber) {
        return seatDao.isSeatAvailable(tripId, seatNumber);
    }

    @Override
    public String getSeatType(int tripId, int seatNumber) {
        return seatDao.getSeatType(tripId, seatNumber);
    }
}
