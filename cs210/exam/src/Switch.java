import java.util.Random;

public class Switch implements Runnable {
    private static boolean isOn;

    private String name;

    public Switch(String name) {
        this.name = name;
        isOn = false;
    }

    public void toggle() {
        System.out.println(name + ": " + isOn);
        isOn = !isOn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                toggle();
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted.");
                break;
            }
        }
    }
}
