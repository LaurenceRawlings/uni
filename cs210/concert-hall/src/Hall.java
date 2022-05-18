public class Hall {
    public static final int MAX = 20;

    private Terminal t1;
    private Terminal t2;

    private void setup() {
        BookingSystem bookings = new BookingSystem();
        t1 = new Terminal(bookings);
        t2 = new Terminal(bookings);
    }

    public void go() throws InterruptedException {
        setup();
        Thread terminal1Thread = new Thread(t1, "terminal1");
        Thread terminal2Thread = new Thread(t2, "terminal2");

        terminal1Thread.start();
        terminal2Thread.start();

        terminal1Thread.join();
        terminal2Thread.join();
    }
}