public class U1901Bank {
    private int intTo;
    private int intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("before Thread=" + Thread.currentThread().getName() + ", From=" + intFrom + ", To=" + intTo);
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.println("After Thread=" + Thread.currentThread().getName() + ", From=" + intFrom + ", To=" + intTo);
    }
}
