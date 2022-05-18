import java.util.ArrayList;

public class BookingSystem {
    private ArrayList<Seat> SEATS;

    public BookingSystem() {
        SEATS = new ArrayList<>();
        for (int i = 0; i < Hall.MAX; i++) {
            SEATS.add(new Seat());
        }
    }

    public static void HWInterrupt(){
        if (Math.random()>0.5)
            Thread.yield();
    }

    public synchronized void reserve(int seatId) {
        Seat seat = getSeat(seatId);
        HWInterrupt();
        try {
            if (!seat.query()) {
                seat.reserve();
                System.out.println("You have booked seat " + seatId);
            } else {
                System.out.println("Sorry, seat " + seatId +  " is reserved.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Seat getSeat(int seatId) {
        for (Seat seat : SEATS) {
            if (seat.getId() == seatId) {
                return seat;
            }
        }
        return null;
    }
}
