import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FileReader {
    public static PriorityQueue<Patient> readProfileSet(String filename) {
        File file = new File(filename);
        Scanner in = null;

        try {
            in = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
            System.exit(0);
        }

        return readProfileSet(in);
    }

    private static PriorityQueue<Patient> readProfileSet(Scanner in) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        while (in.hasNextLine()) {
            queue.add(new Patient(in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
        }

        in.close();
        return queue;
    }
}
