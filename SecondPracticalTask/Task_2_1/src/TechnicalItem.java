class TechnicalItem extends GenericItem {
    public short warrantyTime;

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("Warranty Time: %d days\n", warrantyTime);
    }
}