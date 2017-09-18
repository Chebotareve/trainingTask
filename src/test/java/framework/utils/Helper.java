package framework.utils;

public class Helper {
    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void delay(int delayMilliSeconds) {
        try {
            Thread.sleep(delayMilliSeconds);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
