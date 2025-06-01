package com.data.session16.dao;

import com.data.session16.model.Bus;
import com.data.session16.model.BusType;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class BusDaoImp implements BusDao{
    @Override
    public boolean addBus(Bus bus) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call add_bus(?, ?, ?, ?, ?)}");
            callst.setString(1, bus.getLicensePlate());
            callst.setString(2, String.valueOf(bus.getBusType()));
            callst.setInt(3, bus.getRowSeat());
            callst.setInt(4, bus.getColSeat());
            callst.setString(5, bus.getImage());
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public Bus getBusById(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_bus_by_id(?)}");
            callst.setInt(1, id);
            rs = callst.executeQuery();
            if (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("licensePlate"));
                bus.setBusType(BusType.valueOf(rs.getString("busType")));
                bus.setRowSeat(rs.getInt("rowSeat"));
                bus.setColSeat(rs.getInt("colSeat"));
                bus.setTotalSeat(rs.getInt("totalSeat"));
                bus.setImage(rs.getString("image"));
                return bus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }

    @Override
    public boolean updateBus(Bus bus) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call update_bus(?, ?, ?, ?, ?, ?)}");
            callst.setInt(1, bus.getId());
            callst.setString(2, bus.getLicensePlate());
            callst.setString(3, String.valueOf(bus.getBusType()));
            callst.setInt(4, bus.getRowSeat());
            callst.setInt(5, bus.getColSeat());
            callst.setString(6, bus.getImage());
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean deleteBus(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call delete_bus(?)}");
            callst.setInt(1, id);
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public List<Bus> getAllBuses() {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_all_buses()}");
            rs = callst.executeQuery();
            List<Bus> buses = new java.util.ArrayList<>();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("licensePlate"));
                bus.setBusType(BusType.valueOf(rs.getString("busType")));
                bus.setRowSeat(rs.getInt("rowSeat"));
                bus.setColSeat(rs.getInt("colSeat"));
                bus.setTotalSeat(rs.getInt("totalSeat"));
                bus.setImage(rs.getString("image"));
                buses.add(bus);
            }
            return buses;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }
}
