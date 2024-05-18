package org.example.service;

import org.example.dao.HibernateICatDAO;
import org.example.model.Cat;

public class CatService implements ICatService {
    private final HibernateICatDAO catDAO;

    public CatService(HibernateICatDAO catDAO) {
        this.catDAO = catDAO;
    }

    public Cat getCat(int id) {
        return catDAO.findById(id);
    }

    public void saveCat(Cat cat) {
        catDAO.save(cat);
    }

    public void deleteCat(Cat cat) {
        catDAO.delete(cat);
    }
}