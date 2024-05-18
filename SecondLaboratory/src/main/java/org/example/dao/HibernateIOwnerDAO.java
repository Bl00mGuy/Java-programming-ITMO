package org.example.dao;

import org.example.model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateIOwnerDAO implements IOwnerDAO {
    private final SessionFactory sessionFactory;

    public HibernateIOwnerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Owner save(Owner cat) {
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
    public void delete(Owner cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Owner findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Owner.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Owner> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Owner", Owner.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}