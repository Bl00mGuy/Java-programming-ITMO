import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        FoodItem foodItem1 = new FoodItem();
        foodItem1.ID = 1;
        foodItem1.name = "Milk";
        foodItem1.price = 2.49f;
        foodItem1.dateOfIncome = new Date();
        foodItem1.expires = 7;

        FoodItem foodItem2 = new FoodItem();
        foodItem2.ID = 2;
        foodItem2.name = "Bread";
        foodItem2.price = 1.99f;
        foodItem2.dateOfIncome = new Date();
        foodItem2.expires = 5;

        System.out.println("foodItem1 equals foodItem2: " + foodItem1.equals(foodItem2));

        FoodItem foodItem1Clone = (FoodItem) foodItem1.clone();
        System.out.println("foodItem1 equals foodItem1Clone: " + foodItem1.equals(foodItem1Clone));
    }
}