package com.data.service.screenroom;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomService{
    List<ScreenRoom> findAllActive();
    ScreenRoom findById(Long id);
    void save(ScreenRoom screenRoom);
    void delete(ScreenRoom screenRoom);
    void updateScreenRoom(ScreenRoom updatedRoom);
}
