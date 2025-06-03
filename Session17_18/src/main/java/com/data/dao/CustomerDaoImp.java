package com.data.dao;

import com.data.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean addCustomer(Customer customer) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Customer login(String username, String password) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Customer WHERE username = :username AND password = :password";
            return session.createQuery(hql, Customer.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
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
    public List<Customer> getAllCustomers() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.createQuery("FROM Customer", Customer.class).list();
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
    public List<Customer> searchCustomerByName(String username) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Customer WHERE username LIKE :username";
            return session.createQuery(hql, Customer.class)
                    .setParameter("username", "%" + username + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean lockCustomer(Customer customer) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            customer.setStatus(false);
            session.update(customer);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean unlockCustomer(Customer customer) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            customer.setStatus(true);
            session.update(customer);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = null;
        Customer customer = null;
        try {
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, id);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
