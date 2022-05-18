public class Seat {
    private static int currentId = 0;

    private int id;
    private boolean booked;

    public Seat() {
        id = currentId++;
        booked = false;
    }

    public int getId() {
        return id;
    }

    public void reserve() throws Exception {
        if (booked) {
            throw new Exception("Seat already booked!");
        } else {
            booked = true;
        }
    }

    public boolean query() {
        return booked;
    }
}
