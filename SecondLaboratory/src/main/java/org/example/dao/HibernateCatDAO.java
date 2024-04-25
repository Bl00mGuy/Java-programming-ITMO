package org.example.dao;

import org.example.model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HibernateCatDAO implements CatDAO {
    private final SessionFactory sessionFactory;

    public HibernateCatDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cat save(Cat cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(cat);
            transaction.commit();
            return cat;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Cat cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cat findById(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cat.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cat> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Cat", Cat.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
