import java.util.ArrayList;

public class LabController {
    private int capacity;
    private int spacesLeft;
    private ArrayList<Integer> validIds;
    private ArrayList<Integer> students;

    public int getSpacesLeft() {
        return spacesLeft;
    }

    public LabController(int capacity) {
        this.capacity = capacity;
        spacesLeft = capacity;
        validIds = new ArrayList<Integer>() {
            {
                add(991368);
            }
        };
    }

    public synchronized boolean enter(int studentId) throws InterruptedException {
        while (spacesLeft == 0) {
            wait();
        }

        if (validIds.contains(studentId)) {
            spacesLeft--;
            students.add(studentId);
            notifyAll();
            return true;
        }

        notifyAll();
        return false;
    }

    public synchronized  void leave(int studentId) throws InterruptedException {
        while (spacesLeft == capacity) {
            wait();
        }

        if (students.contains(studentId)) {
            spacesLeft++;
            students.remove((Integer) studentId);
        }

        notifyAll();
    }
}
