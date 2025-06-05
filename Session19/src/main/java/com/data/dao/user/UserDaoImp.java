package com.data.dao.user;

import com.data.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAll(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from User", User.class).getResultList();
        }
    }

    @Override
    public List<User> findAll(int page, int size){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from User", User.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .getResultList();
        }
    }

    @Override
    public void changeStatus(Long id, boolean status){
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            if(user != null) {
                user.setActive(status);
                session.merge(user);
            }
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
    }


    @Override
    public long count(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("select count(*) from User", Long.class)
                    .getSingleResult();
        }
    }
}
