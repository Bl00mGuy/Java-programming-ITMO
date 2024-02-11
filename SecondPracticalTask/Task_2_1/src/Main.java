import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FoodItem foodItem = new FoodItem();
        foodItem.ID = 1;
        foodItem.name = "Milk";
        foodItem.price = 2.49f;
        foodItem.dateOfIncome = new Date();
        foodItem.expires = 7;

        TechnicalItem technicalItem = new TechnicalItem();
        technicalItem.ID = 2;
        technicalItem.name = "Laptop";
        technicalItem.price = 999.99f;
        technicalItem.warrantyTime = 365;

        GenericItem[] items = {foodItem, technicalItem};

        for (GenericItem item : items) {
            item.printAll();
        }
    }
}