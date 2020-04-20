package utils;

public class Util {

    public void SynchronousDelay(int timeout) {
        Object LOCK = new Object();
        try {
            synchronized (LOCK) {
                LOCK.wait(timeout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
