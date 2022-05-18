import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Patient> queue = FileReader.readProfileSet("patients.txt");

        System.out.println("The doctor will see patients in the following order:");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.peek().toString());
            queue.remove();
        }
    }
}
