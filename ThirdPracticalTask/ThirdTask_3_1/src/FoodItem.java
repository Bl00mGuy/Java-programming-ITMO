import java.util.Date;

class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price: %5.2f \n", ID, name, price);
    }

    public FoodItem(String name, float price, FoodItem analogue, Date date, short expires) {
        super(name, price, Category.FOOD);
        this.analogue = analogue;
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name) {
        this(name, 0, null, null, (short)0);
    }
}