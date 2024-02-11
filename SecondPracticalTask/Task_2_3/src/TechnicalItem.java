class TechnicalItem extends GenericItem {
    public short warrantyTime;

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("Warranty Time: %d days\n", warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty Time: " + warrantyTime + " days";
    }
}