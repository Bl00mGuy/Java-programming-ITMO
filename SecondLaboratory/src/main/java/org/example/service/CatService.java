package org.example.service;

import org.example.model.Cat;
import org.example.model.Owner;

import java.time.LocalDate;
import java.util.List;

public interface CatService {
    Cat registerCat(String name, LocalDate birthDate, String breed, String color, Owner owner);
    void makeFriends(Cat cat1, Cat cat2);
    List<Cat> findFriends(Cat cat);
}