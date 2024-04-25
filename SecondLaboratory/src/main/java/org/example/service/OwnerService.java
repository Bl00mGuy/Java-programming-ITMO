package org.example.service;

import org.example.model.Cat;
import org.example.model.Owner;

import java.time.LocalDate;
import java.util.List;

public interface OwnerService {
    Owner registerOwner(String name, LocalDate birthDate);
    List<Owner> findAllOwners();
    List<Cat> findCatsByOwner(Owner owner);
}