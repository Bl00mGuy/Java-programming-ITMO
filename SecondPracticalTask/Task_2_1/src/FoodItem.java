import java.util.Date;

class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("Date of Income: %s , Expires: %d days\n", dateOfIncome.toString(), expires);
    }
}