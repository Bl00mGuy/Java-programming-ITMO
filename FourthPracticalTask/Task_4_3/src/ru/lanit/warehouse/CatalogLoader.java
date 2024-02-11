package ru.lanit.warehouse;

import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {
    void load(ItemCatalog cat);
}
