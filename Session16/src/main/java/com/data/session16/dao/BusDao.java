package com.data.session16.dao;

import com.data.session16.model.Bus;

import java.util.List;

public interface BusDao {
    boolean addBus(Bus bus);
    Bus getBusById(int id);
    boolean updateBus(Bus bus);
    boolean deleteBus(int id);
    List<Bus> getAllBuses();
}
