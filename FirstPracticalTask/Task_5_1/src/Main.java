public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9};
        int maximum = Integer.MIN_VALUE;
        for (var num: array) {
            if (num > maximum) maximum = num;
        }
        System.out.println(maximum);
    }
}