package com.data.service.screenroom;

import com.data.entity.ScreenRoom;
import com.data.dao.screenroom.ScreenRoomDao;
import com.data.dao.seat.SeatDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService{
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private ScreenRoomDao screenRoomRepo;
    @Autowired
    private SeatDao seatRepo;

    @Override
    public List<ScreenRoom> findAllActive(){
        return screenRoomRepo.findAllActive();
    }

    @Override
    public ScreenRoom findById(Long id){
        return screenRoomRepo.findById(id);
    }

    @Override
    public void save(ScreenRoom screenRoom) {
        screenRoomRepo.save(screenRoom);
    }

    @Override
    public void delete(ScreenRoom screenRoom){
        screenRoomRepo.delete(screenRoom);
    }

    public void updateScreenRoom(ScreenRoom updatedRoom) {
       screenRoomRepo.save(updatedRoom);
    }


    private int extractNumber(String seatNumber) {
        return Integer.parseInt(seatNumber.replaceAll("\\D+", ""));
    }

}
