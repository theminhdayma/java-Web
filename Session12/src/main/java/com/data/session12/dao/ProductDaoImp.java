package com.data.session12.dao;

import com.data.session12.model.Product;
import com.data.session12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao{
    @Override
    public boolean addProduct(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call add_product(?, ?, ?, ?)}");
            callst.setString(1, product.getName());
            callst.setDouble(2, product.getPrice());
            callst.setString(3, product.getDescription());
            callst.setString(4, String.valueOf(product.getImage()));
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public Product getProductById(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_product_by_id(?)}");
            callst.setInt(1, id);
            rs = callst.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                return product;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call update_product(?, ?, ?, ?, ?)}");
            callst.setInt(1, product.getId());
            callst.setString(2, product.getName());
            callst.setDouble(3, product.getPrice());
            callst.setString(4, product.getDescription());
            callst.setString(5, String.valueOf(product.getImage()));
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call delete_product(?)}");
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
    public List<Product> getAllProducts() {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_all_products()}");
            rs = callst.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }

    @Override
    public List<Product> searchProducts(String productName) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call search_products(?)}");
            callst.setString(1, productName);
            rs = callst.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }
}
