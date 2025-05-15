package com.data.session09.dao;


import com.data.session09.model.Schedule;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        List<Schedule> list = new ArrayList<>();
        String sql = "{CALL get_schedules_by_movie(?)}";

        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setLong(1, movieId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setMovieTitle(rs.getString("movieTitle"));
                schedule.setScreenRoomId(rs.getLong("screen_room_id"));
                schedule.setShowTime(rs.getTimestamp("show_time"));
                schedule.setAvailableSeats(rs.getInt("availableSeats"));
                list.add(schedule);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
