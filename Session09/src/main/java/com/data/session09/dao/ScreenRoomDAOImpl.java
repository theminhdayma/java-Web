package com.data.session09.dao;

import com.data.session09.model.ScreenRoom;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScreenRoomDAOImpl implements ScreenRoomDAO {

    @Override
    public List<ScreenRoom> getAllScreenRooms() {
        List<ScreenRoom> list = new ArrayList<>();
        String sql = "{CALL get_all_screen_rooms()}";

        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ScreenRoom room = new ScreenRoom();
                room.setId(rs.getLong("id"));
                room.setScreenRoomName(rs.getString("name"));
                room.setTotalSeat(rs.getInt("capacity"));
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
