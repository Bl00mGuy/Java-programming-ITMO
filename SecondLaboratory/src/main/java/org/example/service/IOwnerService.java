package org.example.service;

import org.example.model.Owner;

public interface IOwnerService {
    Owner getOwner(int id);
    void saveOwner(Owner owner);
    void deleteOwner(Owner owner);
}