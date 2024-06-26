package ru.lanit.warehouse;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {
    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        try {
            GenericItem item1 = new GenericItem("Sony TV", 23000, Category.ELECTRONICS);
            FoodItem item2 = new FoodItem("Bread", 12, Category.FOOD, new Date(), (short) 10);
            cat.addItem(item1);
            cat.addItem(item2);
        } catch (ItemAlreadyExistsException e) {
            throw new CatalogLoadException("Error loading catalog", e);
        }
    }
}
