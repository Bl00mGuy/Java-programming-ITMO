public class Main {
    public static void main(String[] args) {
        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld;
        item_fld = line.split(";");
        String name = item_fld[0];
        float price = Float.parseFloat(item_fld[1]);
        short expires = Short.parseShort(item_fld[2]);

        FoodItem foodItem = new FoodItem(name, price, expires);

        foodItem.printAll();
    }
}