public class Main {
    public static void main(String[] args) {
        System.out.println("First task:");
        var first = new LettersAThroughZ();
        first.start();

        System.out.println("\nSecond task:");
        var second = new VariableChanges();
        second.start();
    }
}