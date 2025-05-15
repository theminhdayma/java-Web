package com.data.session09.dao;
import com.data.session09.model.User;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "{CALL find_user_login(?, ?)}";

        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setEnabled(rs.getBoolean("enabled"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(username, password, email, role, enabled) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());
            stmt.setBoolean(5, user.isEnabled());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

