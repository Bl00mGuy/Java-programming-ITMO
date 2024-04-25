package org.example.dao;

import org.example.model.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerDAO {
    Owner save(Owner owner);
    void delete(Owner owner);
    Owner findById(UUID id);
    List<Owner> findAll();
}