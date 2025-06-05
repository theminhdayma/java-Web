package com.data.dao.seat;

import com.data.entity.Seat;

import java.util.List;

public interface SeatDao {
    void save(Seat seat);
    void saveAll(List<Seat> seats);
    public List<Seat> findByScreenRoomId(Long screenRoomId);
    void delete(Seat seat);
}
