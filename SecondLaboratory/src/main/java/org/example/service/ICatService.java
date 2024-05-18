package org.example.service;

import org.example.model.Cat;

public interface ICatService {
    Cat getCat(int id);
    void saveCat(Cat cat);
    void deleteCat(Cat cat);
}