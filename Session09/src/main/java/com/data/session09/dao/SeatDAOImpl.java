package com.data.session09.dao;
import com.data.session09.model.Seat;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatDAOImpl implements SeatDAO {

    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        List<Seat> seats = new ArrayList<>();
        String sql = "{CALL get_seats_by_screen_room(?)}";

        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setLong(1, screenRoomId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getLong("id"));
                seat.setSeatNumber(rs.getString("seat_number"));
                seat.setBooked(rs.getBoolean("is_booked"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }

    @Override
    public List<Long> getBookedSeatsBySchedule(Long scheduleId) {
        List<Long> bookedSeatIds = new ArrayList<>();
        String sql = "{CALL get_booked_seats_by_schedule(?)}";

        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setLong(1, scheduleId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bookedSeatIds.add(rs.getLong("seat_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookedSeatIds;
    }
}
