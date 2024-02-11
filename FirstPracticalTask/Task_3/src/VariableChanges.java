public class VariableChanges {
    public void start() {
        long begin = new java.util.Date().getTime();
        long i = 0;
        while (i < 100000000) {
            i++;
        }
        long end = new java.util.Date().getTime();
        System.out.println(end - begin);
    }
}