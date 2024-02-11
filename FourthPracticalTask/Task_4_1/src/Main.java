import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ItemCatalog cat = new ItemCatalog();

        // Добавление нескольких товаров
        for (int i = 0; i < 10; i++) {
            GenericItem item = new GenericItem();
            item.ID = i; // Установка ID товара
            // Другие параметры товара
            cat.addItem(item);
        }

        // Сравнение скорости поиска по двум типам коллекций
        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++)
            cat.findItemByID(10);

        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++)
            cat.findItemByIDAL(10);

        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));
    }
}