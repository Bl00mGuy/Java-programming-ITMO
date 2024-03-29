public class Main {
    public static void main(String[] args) {
        U1901Bank bankMain = new U1901Bank();

        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000);
        threadOne.setName("thread_100");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("thread_50");
        threadTwo.start();

        System.out.println("End, main");
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}