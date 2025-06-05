package com.data.dao.screenroom;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomDao {
   List<ScreenRoom> findAllActive();
   ScreenRoom findById(Long id);
   void save(ScreenRoom screenRoom);
   void delete(ScreenRoom screenRoom);
}
