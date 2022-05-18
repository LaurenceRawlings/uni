public class Main {

    public static void main(String[] args) {
	    Hall hall = new Hall();

        try {
            hall.go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
