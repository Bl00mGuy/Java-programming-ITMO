public class Main {
    public static void main(String[] args) {
        Integer intArr[] = {10, 20, 15};

        Float[] floatArr = {10.5f, 20.3f, 15.8f};

        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);

        System.out.println("Sum of intArr elements: " + insWorkArrayInt.sum());
        System.out.println("Sum of floatArr elements: " + insWorkArrayFloat.sum());
    }
}