package org.example.dao;

import org.example.model.Cat;

import java.util.List;

public interface ICatDAO {
    Cat save(Cat cat);
    void delete(Cat cat);
    Cat findById(int id);
    List<Cat> findAll();
}