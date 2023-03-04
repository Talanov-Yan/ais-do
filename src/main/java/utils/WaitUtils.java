package utils;

public class WaitUtils {
    public static void waitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ignore) {
        }
    }
}
