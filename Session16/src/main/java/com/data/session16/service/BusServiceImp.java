package com.data.session16.service;

import com.data.session16.dao.BusDao;
import com.data.session16.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BusServiceImp implements BusService {

    @Autowired
    private BusDao busDao;

    @Override
    public boolean addBus(Bus bus) {
        return busDao.addBus(bus);
    }

    @Override
    public Bus getBusById(int id) {
        return busDao.getBusById(id);
    }

    @Override
    public boolean updateBus(Bus bus) {
        return busDao.updateBus(bus);
    }

    @Override
    public boolean deleteBus(int id) {
        return busDao.deleteBus(id);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busDao.getAllBuses();
    }
}
