package org.example.controller;

import org.example.model.Owner;
import org.example.service.OwnerService;

public class OwnerController {
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public Owner GetOwner(int id) {
        return ownerService.getOwner(id);
    }

    public void SaveOwner(Owner owner) {
        ownerService.saveOwner(owner);
    }

    public void DeleteOwner(Owner owner) {
        ownerService.deleteOwner(owner);
    }
}