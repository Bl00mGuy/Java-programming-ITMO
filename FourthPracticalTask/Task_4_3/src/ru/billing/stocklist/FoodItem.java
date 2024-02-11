package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date expirationDate;
    private short discount;

    public FoodItem(String name, float price, Category category, Date expirationDate, short discount) {
        super(name, price, category);
        this.expirationDate = expirationDate;
        this.discount = discount;
    }

    public FoodItem(String name, float price, Date expirationDate, short discount) {
        this(name, price, null, expirationDate, discount);
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }
}
