public class Terminal implements Runnable {
    private BookingSystem bookings;

    public Terminal(BookingSystem bookings) {
        this.bookings = bookings;
    }

    @Override
    public void run() {
        double r;
        int wait;
        for (int i = 0; i < Hall.MAX; i++){
            r = Math.random();
            wait = (int) Math.ceil(r * 10);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bookings.reserve(i);
        }
    }
}
