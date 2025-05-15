package com.data.session06.dao.Bai3;

import com.data.session06.model.Bai3.Product;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProducts = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_products()}");
            ResultSet rs = callSt.executeQuery();
            listProducts = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setImageUrl(rs.getString("imageUrl"));
                listProducts.add(product);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProducts;
    }

    @Override
    public boolean addProductToCart(int userId, int productId, int quantity) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_product_to_cart(?, ?, ?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, productId);
            callSt.setInt(3, quantity);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}
