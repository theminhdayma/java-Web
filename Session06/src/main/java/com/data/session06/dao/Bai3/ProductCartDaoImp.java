package com.data.session06.dao.Bai3;

import com.data.session06.model.Bai3.ProductCart;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDaoImp implements ProductCartDao {
    @Override
    public List<ProductCart> findCartByUserId(int userId) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<ProductCart> listCarts = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_cart_by_userId(?)}");
            callSt.setInt(1, userId);
            listCarts = new ArrayList<>();
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ProductCart productCart = new ProductCart();
                productCart.setId(rs.getInt("cart_id"));
                productCart.setUserId(rs.getInt("cart_userId"));
                productCart.setProductId(rs.getInt("product_id"));
                productCart.setQuantity(rs.getInt("cart_quantity"));
                productCart.setName(rs.getString("product_name"));
                productCart.setPrice(rs.getDouble("product_price"));
                listCarts.add(productCart);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCarts;
    }

    @Override
    public boolean removeProductFromCart(int userId, int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean isDeleted = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call remove_product_from_cart(?, ?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, productId);
            int rowsAffected = callSt.executeUpdate();
            if (rowsAffected > 0) {
                isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isDeleted;
    }
}
