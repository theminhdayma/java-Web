package com.data.dao.seat;

import com.data.entity.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatDaoImp implements SeatDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Seat seat){
        try(Session session = sessionFactory.openSession()){
            Transaction tx=session.beginTransaction();
            session.save(seat);
            tx.commit();
        }
    }

    @Override
    public void saveAll(List<Seat> seats){
        try(Session session=sessionFactory.openSession()){
            Transaction tx=session.beginTransaction();
            for(Seat seat:seats){
                session.save(seat);
            }
            tx.commit();
        }
    }

    @Override
    public List<Seat> findByScreenRoomId(Long screenRoomId){
        return sessionFactory.openSession()
                .createQuery("from Seat s where s.screenRoom.id=:screenRoomId", Seat.class)
                .setParameter("screenRoomId", screenRoomId)
                .getResultList();
    }

    @Override
    public void delete(Seat seat){
        try(Session session=sessionFactory.openSession()){
            Transaction tx=session.beginTransaction();
            session.delete(seat);
            tx.commit();
        }
    }
}
