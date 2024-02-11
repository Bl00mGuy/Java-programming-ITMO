class GenericItem {
    public int ID;
    public String name;
    public float price;
    public GenericItem analogue;
    public Category category;
    public static int currentID = 1;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price: %5.2f , Category: %s\n", ID, name, price, category);
    }

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = currentID++;
    }

    public GenericItem(String name, float price, GenericItem analogue, Category category) {
        this.name = name;
        this.price = price;
        this.analogue = analogue;
        this.category = category;
        this.ID = currentID++;
    }

    public GenericItem() {
        this.ID = currentID++;
    }
}
