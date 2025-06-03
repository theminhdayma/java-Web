package com.data.dao;

import com.data.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll(int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        }
    }

    @Override
    public Product findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    @Override
    public long countAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(p.id) FROM Product p", Long.class);
            Long count = query.uniqueResult();
            return count != null ? count.intValue() : 0;
        }
    }

    @Override
    public List<Product> getAllProduct() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            return query.getResultList();
        }
    }

    @Override
    public List<Product> filterProductByPrice(double minPrice, double maxPrice) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product WHERE price BETWEEN :min AND :max";
            return session.createQuery(hql, Product.class)
                    .setParameter("min", minPrice)
                    .setParameter("max", maxPrice)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
