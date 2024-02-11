package ru.billing.client;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.lanit.warehouse.CatalogLoader;
import ru.lanit.warehouse.CatalogStubLoader;

public class Main {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();

        CatalogLoader loader = new CatalogStubLoader();

        loader.load(catalog);

        System.out.println("Items in the catalog:");
        catalog.printItems();

        GenericItem manualItem = new GenericItem("Book", 100.0f, Category.GENERAL);
        catalog.addItem(manualItem);

        System.out.println("\nItems in the catalog after manual addition:");
        catalog.printItems();
    }
}
