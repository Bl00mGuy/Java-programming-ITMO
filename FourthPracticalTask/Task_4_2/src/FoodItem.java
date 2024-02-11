import java.util.Date;

public class FoodItem extends GenericItem {
    Date expirationDate;
    short discount;

    public FoodItem(String name, double price, Category category, Date expirationDate, short discount) {
        super(name, price, category);
        this.expirationDate = expirationDate;
        this.discount = discount;
    }
}