package org.example.dao;

import org.example.model.Cat;

import java.util.List;
import java.util.UUID;

public interface CatDAO {
    Cat save(Cat cat);
    void delete(Cat cat);
    Cat findById(UUID id);
    List<Cat> findAll();
}