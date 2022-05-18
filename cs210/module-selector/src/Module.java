import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Semaphore;

/**
 * Models a module that students a can enroll on, and is the shared resource for the Student threads.
 *
 * @author Laurence Rawlings (991368)
 */
public class Module {
    private String title;
    private int code;
    private String coordinator;

    private ArrayList<Integer> students;
    private Semaphore places;

    public Module(String title, int code, String coordinator, int capacity) {
        this.title = title;
        this.code = code;
        this.coordinator = coordinator;

        students = new ArrayList<>();
        places = new Semaphore(capacity);
    }

    public int getCode() {
        return code;
    }

    public int getEnrolled() {
        return students.size();
    }

    private boolean isEnrolled(int studentId) {
        return students.contains(studentId);
    }

    public boolean tryEnroll(int studentId) {
        System.out.println(String.format("     [%d] Enroll initiated: CS-%d", studentId, code));
        if (!isEnrolled(studentId)) {
            if (places.tryAcquire()) {
                addStudent(studentId);
                System.out.println(String.format("     [%d] Enroll finished: CS-%d", studentId, code));
                return true;
            } else {
                System.out.println(String.format("     [%d] Enroll error! (module at capacity): CS-%d", studentId,
                        code));
            }
        } else {
            System.out.println(String.format("     [%d] Enroll error! (already enrolled): CS-%d", studentId, code));
        }
        return false;
    }

    public boolean tryTransfer(Module other, int studentId) {
        System.out.println(String.format("     [%d] Transfer initiated: CS-%d -> CS-%d", studentId, code,
                other.getCode()));
        if (isEnrolled(studentId)) {
            if (other.equals(this)) {
                System.out.println(String.format("     [%d] Transfer error! (can't enroll to same module): CS-%d -> CS-%d",
                        studentId, code, other.getCode()));
                return false;
            }
            if (other.tryEnroll(studentId)) {
                removeStudent(studentId);
                places.release();
                System.out.println(String.format("     [%d] Transfer finished: CS-%d -> CS-%d", studentId, code,
                        other.getCode()));
                return true;
            } else {
                System.out.println(
                        String.format("     [%d] Transfer error! (enroll failed): CS-%d", studentId, other.getCode()));
            }
        } else {
            System.out.println(String.format("     [%d] Transfer error! (not enrolled): CS-%d", studentId, code));
        }
        return false;
    }

    private synchronized void addStudent(Integer studentId) {
        students.add(studentId);
    }

    private synchronized void removeStudent(Integer studentId) {
        students.remove(studentId);
    }

    @Override
    public String toString() {
        return String.format("CS-%d: %s\nCoordinator: %s\nEnrolled: %d\nRemaining Places: %d\nEnrolled Students: %s",
                code, title, coordinator, getEnrolled(), places.availablePermits(), students.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Module module = (Module) o;
        return code == module.code && title.equals(module.title) && coordinator.equals(module.coordinator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, coordinator);
    }
}
