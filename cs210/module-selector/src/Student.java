import java.util.Random;

/**
 * Models a student that can enroll on to modules, implements Runnable so can be put onto a thread and simulated
 * concurrently.
 *
 * @author Laurence Rawlings (991368)
 */
public class Student implements Runnable {
    private static int CURRENT_ID = 0;

    private int id;
    private int modulesEnrolled;

    private Random random;

    public Student() {
        id = CURRENT_ID++;
        modulesEnrolled = 0;
        random = new Random();
    }

    private Module getRandomModule() {
        return Uni.SIMULATION_MODULES[random.nextInt(Uni.SIMULATION_MODULES.length)];
    }

    @Override
    public void run() {
        boolean simulate = true;
        while (simulate) {
            try {
                Thread.sleep(random.nextInt(100));

                int chance = (modulesEnrolled / Uni.SIMULATION_MODULES.length) * 100;
                if (random.nextInt(100) > chance) {
                    System.out.println(String.format("[%d] Enrolling...", id));
                    enroll();
                } else {
                    System.out.println(String.format("[%d] Transferring...", id));
                    transfer();
                }
            } catch (InterruptedException ex) {
                simulate = false;
            }
        }
    }

    private void enroll() {
        if (getRandomModule().tryEnroll(id)) {
            modulesEnrolled++;
        }
    }

    private void transfer() {
        Module module1 = getRandomModule();
        Module module2 = getRandomModule();

        module1.tryTransfer(module2, id);
    }
}
