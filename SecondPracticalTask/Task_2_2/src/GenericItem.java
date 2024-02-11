class GenericItem {
    public int ID;
    public String name;
    public float price;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price: %5.2f \n", ID, name, price);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID && Float.compare(that.price, price) == 0 && name.equals(that.name);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Price: " + price;
    }
}