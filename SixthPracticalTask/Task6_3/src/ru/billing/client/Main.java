package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.stocklist.ItemCatalog;
import ru.lanit.warehouse.CatalogFileLoader;
import ru.lanit.warehouse.CatalogLoader;

public class Main {
    public static void main(String[] args) {
        String fileName = "C://Users/goodd/IdeaProjects/Java-programming-ITMO/SixthPracticalTask/Task6_3/src/items.txt";
        CatalogLoader loader = new CatalogFileLoader(fileName);
        ItemCatalog catalog = new ItemCatalog();

        try {
            loader.load(catalog);
            System.out.println("Catalog loaded successfully:");
            catalog.printItems();
        } catch (CatalogLoadException e) {
            System.err.println("Failed to load catalog: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
