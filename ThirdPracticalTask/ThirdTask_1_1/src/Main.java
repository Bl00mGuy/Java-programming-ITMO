import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericItem genericItem1 = new GenericItem("GenericItem 1", 10.99f, Category.GENERAL);
        GenericItem genericItem2 = new GenericItem("GenericItem 2", 20.49f, genericItem1);
        GenericItem genericItem3 = new GenericItem();

        Date currentDate = new Date();

        FoodItem foodItem1 = new FoodItem("FoodItem 1", 5.99f, null, currentDate, (short)7);
        FoodItem foodItem2 = new FoodItem("FoodItem 2", 7.49f, (short)30);
        FoodItem foodItem3 = new FoodItem("FoodItem 3");

        System.out.println("Generic Items:");
        genericItem1.printAll();
        genericItem2.printAll();
        genericItem3.printAll();

        System.out.println("\nFood Items:");
        foodItem1.printAll();
        foodItem2.printAll();
        foodItem3.printAll();
    }
}
