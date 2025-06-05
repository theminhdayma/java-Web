package com.data.service.seat;

import com.data.entity.Seat;
import com.data.dao.seat.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatDao seatRepo;

    @Override
    public void save(Seat seat){
        seatRepo.save(seat);
    }

    @Override
    public void saveAll(List<Seat> seats){
        seatRepo.saveAll(seats);
    }

    @Override
    public List<Seat> findByScreenRoomId(Long screenRoomId){
        return seatRepo.findByScreenRoomId(screenRoomId);

    }

    @Override
    public void delete(Seat seat){
        seatRepo.delete(seat);
    }
}
