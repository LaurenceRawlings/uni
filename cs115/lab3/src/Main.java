import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File inFile = new File("student_data.txt");

        try {
            Scanner sc = new Scanner(inFile);

            while(sc.hasNextLine()){
                String[] currentStudent = sc.nextLine().split(" ");

                int id = Integer.parseInt(currentStudent[0]);
                int cw1 = Integer.parseInt(currentStudent[3]);
                int cw2 = Integer.parseInt(currentStudent[4]);
                int ex = Integer.parseInt(currentStudent[5]);

                double overall = (cw1 * 0.1) + (cw2 * 0.2) + (ex * 0.8);

                System.out.println(String.format("%s %s -- %d: %.1f", currentStudent[2], currentStudent[1], id, overall));
            }

            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
