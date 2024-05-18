package org.example.service;

import org.example.dao.HibernateIOwnerDAO;
import org.example.model.Owner;

public class OwnerService implements IOwnerService {
    private final HibernateIOwnerDAO ownerDAO;

    public OwnerService(HibernateIOwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    public Owner getOwner(int id) {
        return ownerDAO.findById(id);
    }

    public void saveOwner(Owner owner) {
        ownerDAO.save(owner);
    }

    public void deleteOwner(Owner owner) {
        ownerDAO.delete(owner);
    }
}