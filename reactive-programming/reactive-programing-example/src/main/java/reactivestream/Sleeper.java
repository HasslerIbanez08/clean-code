package reactivestream;

public class Sleeper {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
