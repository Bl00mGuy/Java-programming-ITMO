import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {
    @Override
    public void load(ItemCatalog cat) {
        // Ручная загрузка каталога
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.ELECTRONICS);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);

        // Добавление товаров в каталог
        cat.addItem(item1);
        cat.addItem(item2);
    }
}