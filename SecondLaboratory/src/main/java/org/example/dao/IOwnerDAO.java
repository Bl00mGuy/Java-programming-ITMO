package org.example.dao;

import org.example.model.Owner;

import java.util.List;

public interface IOwnerDAO {
    Owner save(Owner owner);
    void delete(Owner owner);
    Owner findById(int id);
    List<Owner> findAll();
}