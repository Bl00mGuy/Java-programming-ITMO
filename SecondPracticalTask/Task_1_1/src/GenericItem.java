public class GenericItem {
    public int ID;
    public String name;
    public float price;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price: %5.2f \n", ID, name, price);
    }
}
