package com.data.session16.dao;

import com.data.session16.model.Trip;

import java.util.List;

public interface TripDao {
    List<Trip> getAllTrips();
    Trip getTripById(int id);
    List<Trip> searchTripByStartAndEndPoint(String start, String end);
}
