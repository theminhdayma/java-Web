package com.data.session15.dao.Bai6_7_8_9;

import com.data.session15.model.Bai6_7_8_9.*;
import com.data.session15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewDaoImp implements ReviewDao {
    @Override
    public boolean addReview(Review review) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call saveProductReview(?, ?, ?)}");
            callst.setInt(1, review.getProductId());
            callst.setInt(2, review.getRating());
            callst.setString(3, review.getComment());
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
            callst = conn.prepareCall("{call getAllProducts()}");
            rs = callst.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
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
    public List<Review> getReviewsByProductId(int productId) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        List<Review> reviews = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call getAllReviewsByProductId(?)}");
            callst.setInt(1, productId);
            rs = callst.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("id"));
                review.setProductId(rs.getInt("product_id"));
                review.setUserId(rs.getInt("user_id"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return reviews;
    }

    @Override
    public Product getProductById(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call getProductById(?)}");
            callst.setInt(1, id);
            rs = callst.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }

    @Override
    public boolean addToCart(Cart cart) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call addToCart(?, ?)}");
            callst.setInt(1, cart.getProductId());
            callst.setInt(2, cart.getQuantity());
            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public List<Cart> getCartByUserId(int userId) {
    Connection conn = null;
        CallableStatement callst = null;
        ResultSet rs = null;
        List<Cart> carts = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call getCartByUserId(?)}");
            callst.setInt(1, userId);
            rs = callst.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));
                carts.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return carts;
    }

    @Override
    public boolean addOrder(Orders orders) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call addOrder(?, ?, ?, ?)}");
            callst.setInt(1, orders.getUserId());
            callst.setString(2, orders.getRecipientName());
            callst.setString(3, orders.getAddress());
            callst.setString(4, orders.getPhoneNumber());

            return callst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

}
