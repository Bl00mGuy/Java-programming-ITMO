public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem();
        item1.ID = 1;
        item1.name = "Product 1";
        item1.price = 10.99f;
        item1.category = Category.FOOD;

        System.out.println("Item 1:");
        item1.printAll();
    }
}