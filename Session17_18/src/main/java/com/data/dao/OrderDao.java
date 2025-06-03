package com.data.dao;

import com.data.entity.Order;
import com.data.entity.Status;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    List<Order> findByCustomerIdPaginated(int customerId, int page, int size);
    int countPagesByCustomerId(int customerId, int size);
    void cancelOrder(int orderId, int customerId);
    List<Order> getAllOrder();
    List<Order> searchOrderByRecipientName(String recipientName);
    List<Order> FilterOrderByStatus(Status status);
}
