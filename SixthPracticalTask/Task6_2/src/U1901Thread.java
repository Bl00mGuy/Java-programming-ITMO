public class U1901Thread extends Thread {
    private final U1901Bank bankWork;
    private final int intTrans;
    private final long lngSleep;

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    @Override
    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }
}