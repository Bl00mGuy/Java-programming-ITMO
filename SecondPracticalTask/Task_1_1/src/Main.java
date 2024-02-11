public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem();
        item1.ID = 1;
        item1.name = "Product 1";
        item1.price = 10.99f;

        GenericItem item2 = new GenericItem();
        item2.ID = 2;
        item2.name = "Product 2";
        item2.price = 20.49f;

        GenericItem item3 = new GenericItem();
        item3.ID = 3;
        item3.name = "Product 3";
        item3.price = 15.79f;

        System.out.println("Item 1:");
        item1.printAll();

        System.out.println("Item 2:");
        item2.printAll();

        System.out.println("Item 3:");
        item3.printAll();
    }
}