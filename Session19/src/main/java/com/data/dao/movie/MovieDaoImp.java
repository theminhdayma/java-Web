package com.data.dao.movie;

import com.data.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MovieDaoImp implements MovieDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> findAll() {
        return sessionFactory.openSession()
                .createQuery("from Movie", Movie.class)
                .getResultList();
    }

    @Override
    public Movie findById(Long id) {
        return sessionFactory.openSession()
                .get(Movie.class, id);
    }

    @Override
    public void save(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(movie);
            tx.commit();
        }
    }

    @Override
    public void update(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(movie);
            tx.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Movie movie = session.get(Movie.class, id);
            if (movie != null) {
                session.delete(movie);
            }
            tx.commit();
        }
    }

}