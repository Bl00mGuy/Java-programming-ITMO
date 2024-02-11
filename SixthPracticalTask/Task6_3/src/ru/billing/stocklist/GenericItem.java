package ru.billing.stocklist;

public class GenericItem {
    private int ID;
    private String name;
    private float price;
    private Category category;
    private GenericItem analogue;
    private static int currentID = 1;

    public GenericItem() {
        this.ID = currentID++;
    }

    public GenericItem(String name, float price, Category category) {
        this();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, Category category, GenericItem analogue) {
        this(name, price, category);
        this.analogue = analogue;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GenericItem getAnalogue() {
        return analogue;
    }

    public void setAnalogue(GenericItem analogue) {
        this.analogue = analogue;
    }
}
