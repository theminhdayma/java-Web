package com.data.dao;

import com.data.entity.ProductCart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImp implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProductCart findByCustomerIdAndProductId(int customerId, int productId) {
        try (Session session = sessionFactory.openSession()) {
            Query<ProductCart> query = session.createQuery(
                    "FROM ProductCart WHERE customerId = :customerId AND productId = :productId", ProductCart.class);
            query.setParameter("customerId", customerId);
            query.setParameter("productId", productId);
            return query.uniqueResult();
        }
    }


    @Override
    public void save(ProductCart productCart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(productCart);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ProductCart productCart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(productCart);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<ProductCart> findByCustomerId(int customerId) {
        try (Session session = sessionFactory.openSession()) {
            Query<ProductCart> query = session.createQuery(
                    "FROM ProductCart WHERE customerId = :customerId", ProductCart.class);
            query.setParameter("customerId", customerId);
            return query.list();
        }
    }

}
