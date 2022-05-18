/**
 * Main class for the application, sets up and runs the module selection simulation.
 *
 * @author Laurence Rawlings (991368)
 */
public class Uni {
    public static final int SIMULATION_TIME = 10;
    public static final int SIMULATION_STUDENTS = 100;

    public static final Module[] SIMULATION_MODULES = new Module[]{
            new Module("Introduction to Human-Computer Interaction", 200, "LMHC", 100),
            new Module("Declarative Programming", 205, "MS", 120),
            new Module("Concurrency", 210, "AAMR", 80),
            new Module("Software Engineering", 230, "LPO", 100),
            new Module("Database Systems", 250, "KLT", 110),
            new Module("Computer Graphics", 255, "MWJ", 90),
            new Module("Algorithms", 270, "OK", 50),
            new Module("Automata and Formal Language Theory", 275, "BBM", 100)
    };

    public static void main(String[] args) throws InterruptedException {
        Student[] students = new Student[SIMULATION_STUDENTS];

        for (int i = 0; i < SIMULATION_STUDENTS; i++) {
            students[i] = new Student();
        }

        Thread[] studentThreads = new Thread[SIMULATION_STUDENTS];

        for (int i = 0; i < SIMULATION_STUDENTS; i++) {
            studentThreads[i] = new Thread(students[i]);
        }

        for (Thread thread : studentThreads) {
            thread.start();
        }

        Thread.sleep(SIMULATION_TIME * 1000);

        for (Thread thread : studentThreads) {
            thread.interrupt();
        }

        for (Thread thread : studentThreads) {
            thread.join();
        }

        System.out.println();
        for (Module module : SIMULATION_MODULES) {
            System.out.println(module.toString() + "\n");
        }
    }
}
