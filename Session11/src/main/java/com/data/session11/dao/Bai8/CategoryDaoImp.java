package com.data.session11.dao.Bai8;

import com.data.session11.model.Bai8.Category;
import com.data.session11.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImp implements CategoryDao {

    @Override
    public boolean save(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call saveCategory(?)}");
            callSt.setString(1, category.getCategoryName());
            return callSt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error when saving: " + e.getMessage());
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public boolean update(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateCategory(?, ?, ?)}");
            callSt.setInt(1, category.getId());
            callSt.setString(2, category.getCategoryName());
            callSt.setBoolean(3, category.isStatus());
            return callSt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error when updating: " + e.getMessage());
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteCategory(?)}");
            callSt.setInt(1, id);
            return callSt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error when deleting: " + e.getMessage());
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{CALL getAllCategory()}");
            rs = callSt.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("categoryName"),
                        rs.getBoolean("status")
                );
                list.add(category);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{CALL getCategoryById(?)}");
            callSt.setInt(1, id);
            rs = callSt.executeQuery();
            if (rs.next()) {
                category = new Category(
                        rs.getInt("id"),
                        rs.getString("categoryName"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return category;
    }
    @Override
    public boolean isCategoryNameExists(String categoryName) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{CALL checkCategoryExists(?, ?)}");
            callSt.setString(1, categoryName);
            callSt.registerOutParameter(2, Types.BOOLEAN);
            callSt.execute();
            return callSt.getBoolean(2);
        } catch (SQLException e) {
            System.err.println("Error when checking category name: " + e.getMessage());
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

}
