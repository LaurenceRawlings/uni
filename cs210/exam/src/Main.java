public class Main {
    public static void main(String[] args) {
        Switch switch1 = new Switch("switch1");
        Switch switch2 = new Switch("switch2");

        Thread thread1 = new Thread(switch1);
        Thread thread2 = new Thread(switch2);

        try {
            thread1.start();
            thread2.start();

            Thread.sleep(5000);

            thread1.interrupt();
            thread2.interrupt();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


