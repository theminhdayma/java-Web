package com.data.session16.dao;

import com.data.session16.model.Status;
import com.data.session16.model.Trip;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripDaoImp implements TripDao {
    @Override
    public List<Trip> getAllTrips() {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_all_trips()}");
            ResultSet rs = callst.executeQuery();
            List<Trip> trips = new ArrayList<>();
            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setTitle(rs.getString("title"));
                trip.setDescription(rs.getString("description"));
                trip.setStartPoint(rs.getString("start_point"));
                trip.setEndPoint(rs.getString("end_point"));
                trip.setPrice(rs.getDouble("price"));
                trip.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                trips.add(trip);
            }
            return trips;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }

    @Override
    public Trip getTripById(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_trip_by_id(?)}");
            callst.setInt(1, id);
            ResultSet rs = callst.executeQuery();
            if (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setTitle(rs.getString("title"));
                trip.setDescription(rs.getString("description"));
                trip.setStartPoint(rs.getString("start_point"));
                trip.setEndPoint(rs.getString("end_point"));
                trip.setPrice(rs.getDouble("price"));
                trip.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                return trip;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }

    @Override
    public List<Trip> searchTripByStartAndEndPoint(String start, String end) {
    Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call search_trips_by_start_end_points(?, ?)}");
            callst.setString(1, start);
            callst.setString(2, end);
            ResultSet rs = callst.executeQuery();
            List<Trip> trips = new ArrayList<>();
            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setTitle(rs.getString("title"));
                trip.setDescription(rs.getString("description"));
                trip.setStartPoint(rs.getString("start_point"));
                trip.setEndPoint(rs.getString("end_point"));
                trip.setPrice(rs.getDouble("price"));
                trip.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                trips.add(trip);
            }
            return trips;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }
}
