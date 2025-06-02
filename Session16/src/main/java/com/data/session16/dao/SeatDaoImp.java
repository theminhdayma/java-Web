package com.data.session16.dao;

import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public class SeatDaoImp implements SeatDao{
    @Override
    public boolean addSeat(int tripId, int seatNumber, String seatType) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call add_seat(?, ?, ?)}");
            callst.setInt(1, tripId);
            callst.setInt(2, seatNumber);
            callst.setString(3, seatType);
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean updateSeat(int tripId, int seatNumber, String seatType) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call update_seat(?, ?, ?)}");
            callst.setInt(1, tripId);
            callst.setInt(2, seatNumber);
            callst.setString(3, seatType);
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean deleteSeat(int tripId, int seatNumber) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call delete_seat(?, ?)}");
            callst.setInt(1, tripId);
            callst.setInt(2, seatNumber);
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean isSeatAvailable(int tripId, int seatNumber) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call is_seat_available(?, ?)}");
            callst.setInt(1, tripId);
            callst.setInt(2, seatNumber);
            return callst.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public String getSeatType(int tripId, int seatNumber) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_seat_type(?, ?)}");
            callst.setInt(1, tripId);
            callst.setInt(2, seatNumber);
            rs = callst.executeQuery();
            if (rs.next()) {
                return rs.getString("seat_type");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }
}
