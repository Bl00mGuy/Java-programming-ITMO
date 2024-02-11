package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public HashMap<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    public ArrayList<GenericItem> getALCatalog() {
        return ALCatalog;
    }

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsKey(item.getID())) {
            throw new ItemAlreadyExistsException("Item with ID " + item.getID() + " already exists");
        } else {
            catalog.put(item.getID(), item);
            ALCatalog.add(item);
        }
    }

    public void printItems() {
        for (GenericItem item : ALCatalog) {
            System.out.println(item);
        }
    }

    public GenericItem findItemByID(int id) {
        return catalog.get(id);
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem item : ALCatalog) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }
}
