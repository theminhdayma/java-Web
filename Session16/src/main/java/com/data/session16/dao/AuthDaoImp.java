package com.data.session16.dao;

import com.data.session16.model.Role;
import com.data.session16.model.Status;
import com.data.session16.model.User;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public class AuthDaoImp implements AuthDao {
    @Override
    public boolean registerUser(User user) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call register_user(?, ?, ?)}");
            callst.setString(1, user.getUsername());
            callst.setString(2, user.getPassword());
            callst.setString(3, user.getEmail());
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call login(?, ?)}");
            callst.setString(1, username);
            callst.setString(2, password);
            return callst.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean userExists(String username) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call username_exists(?)}");
            callst.setString(1, username);
            return callst.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_user_by_username(?)}");
            callst.setString(1, username);
            rs = callst.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setStatus(rs.getString("status").equalsIgnoreCase("active") ? Status.ACTIVE : Status.INACTIVE);
                return user;
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
