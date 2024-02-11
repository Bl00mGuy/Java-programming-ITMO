package ru.billing.client;

import java.sql.DriverManager;
import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.lanit.warehouse.CatalogLoader;
import ru.lanit.warehouse.CatalogStubLoader;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();

        try {
            GenericItem item1 = new GenericItem("Sony TV", 23000, Category.ELECTRONICS);
            FoodItem item2 = new FoodItem("Bread", 12, Category.FOOD, new Date(), (short) 10);

            catalog.addItem(item1);
            catalog.addItem(item2);

            System.out.println("Items added successfully:");
            catalog.printItems();
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(catalog);
            System.out.println("Catalog loaded successfully:");
            catalog.printItems();
        } catch (CatalogLoadException e) {
            System.out.println("Error loading catalog: " + e.getMessage());
        }
    }
}
