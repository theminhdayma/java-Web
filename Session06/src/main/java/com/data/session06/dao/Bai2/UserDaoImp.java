package com.data.session06.dao.Bai2;

import com.data.session06.model.Bai2.User;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public List<User> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> userLists = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_getAllUser()}");
            ResultSet rs = callSt.executeQuery();
            userLists = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                userLists.add(user);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return userLists;
    }

    @Override
    public boolean save(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_register(?,?,?,?)}");
            callSt.setString(1, user.getUsername());
            callSt.setString(2, user.getPassword());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPhone());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_login(?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);

            rs = callSt.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

}
