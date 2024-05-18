package org.example.controller;

import org.example.model.Cat;
import org.example.service.CatService;

public class CatController {
    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    public Cat GetCat(int id) {
        return catService.getCat(id);
    }

    public void SaveCat(Cat cat) {
        catService.saveCat(cat);
    }

    public void DeleteCat(Cat cat) {
        catService.deleteCat(cat);
    }
}
