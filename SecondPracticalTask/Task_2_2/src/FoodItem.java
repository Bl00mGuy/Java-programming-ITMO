import java.util.Date;

class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("Date of Income: %s , Expires: %d days\n", dateOfIncome.toString(), expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires && dateOfIncome.equals(foodItem.dateOfIncome);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FoodItem clone = (FoodItem) super.clone();
        clone.dateOfIncome = (Date) this.dateOfIncome.clone();
        return clone;
    }

    @Override
    public String toString() {
        return super.toString() + ", Date of Income: " + dateOfIncome + ", Expires: " + expires + " days";
    }
}
