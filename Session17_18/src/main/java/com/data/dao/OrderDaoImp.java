package com.data.dao;

import com.data.entity.Order;
import com.data.entity.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Order> findByCustomerIdPaginated(int customerId, int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order WHERE customerId = :cid ORDER BY id DESC", Order.class);
            query.setParameter("cid", customerId);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        }
    }

    @Override
    public int countPagesByCustomerId(int customerId, int size) {
        try (Session session = sessionFactory.openSession()) {
            Long count = session.createQuery("SELECT COUNT(*) FROM Order WHERE customerId = :cid", Long.class)
                    .setParameter("cid", customerId)
                    .uniqueResult();
            return (int) Math.ceil(count / (double) size);
        }
    }

    @Override
    public void cancelOrder(int orderId, int customerId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order != null && order.getCustomerId() == customerId && "Chờ xử lý".equals(order.getStatus())) {
                order.setStatus(Status.PENDING);
                session.update(order);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Order> getAllOrder() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.createQuery("FROM Order ", Order.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> searchOrderByRecipientName(String recipientName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Order WHERE recipientName LIKE :recipientName";
            return session.createQuery(hql, Order.class)
                    .setParameter("recipientName", "%" + recipientName + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @Override
    public List<Order> FilterOrderByStatus(Status status) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Order WHERE status = :status";
            return session.createQuery(hql, Order.class)
                    .setParameter("status", status)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
