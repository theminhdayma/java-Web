package com.data.dao.theater;

import com.data.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterDaoImp implements TheaterDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Theater> findAll(){
        return sessionFactory.openSession()
                .createQuery("from Theater ",  Theater.class)
                .getResultList();
    }

    @Override
    public Theater findById(Long theaterId){
        return sessionFactory.openSession()
                .get(Theater.class,theaterId);
    }

    @Override
    public void save(Theater theater){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(theater);
            tx.commit();
        }
    }

    @Override
    public void delete(Long theaterId){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            Theater theater = session.get(Theater.class,theaterId);
            if(theater != null){
                session.delete(theater);
            }
            tx.commit();
        }
    }
}
