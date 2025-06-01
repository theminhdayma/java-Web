package com.data.session16.service;

import com.data.session16.dao.TripDao;
import com.data.session16.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImp implements TripService {

    @Autowired
    private TripDao tripDao;

    @Override
    public List<Trip> getAllTrips() {
        return tripDao.getAllTrips();
    }

    @Override
    public Trip getTripById(int id) {
        return tripDao.getTripById(id);
    }

    @Override
    public List<Trip> searchTripByStartAndEndPoint(String start, String end) {
        return tripDao.searchTripByStartAndEndPoint(start, end);
    }
}
