package com.data.service.seat;

import com.data.entity.Seat;

import java.util.List;

public interface SeatService{
    void save(Seat seat);
    void saveAll(List<Seat> seats);
    List<Seat> findByScreenRoomId(Long screenRoomId);
    void delete(Seat seat);
}
