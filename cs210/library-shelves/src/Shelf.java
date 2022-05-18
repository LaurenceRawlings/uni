import org.multiverse.api.StmUtils;
import org.multiverse.api.references.TxnRef;

public class Shelf {
    private Book[] bookArray;
    private int capacity;
    private int id;
    private boolean taken;

    //STM
    private TxnRef[] atomicBookArray;

    Shelf(int capacity, int id) {
        this.id = id;
        this.capacity = capacity;

        bookArray = new Book[capacity];
        for (int i = 0; i < capacity; i++) {
            bookArray[i] = new Book();
        }

        taken = false;


        //STM
        atomicBookArray = new TxnRef[capacity];

        for (int i = 0; i < capacity; i++) {
            atomicBookArray[i] = StmUtils.newTxnRef(new Book());
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public boolean isTaken() {
        return taken;
    }

    public synchronized void acquire() throws InterruptedException {
        while (taken) {
            wait();
        }

        taken = true;
        notifyAll();
    }

    public synchronized void release() {
        taken = false;
        notifyAll();
    }

    public Book getBookAtIndex(int index) {
        return bookArray[index];
    }

    public void setBookAtIndex(int index, Book book) {
        bookArray[index] = book;
    }

    public synchronized void swap(Shelf other, int originIndex, int destIndex) {
        Book origin = getBookAtIndex(originIndex);
        Book dest = other.getBookAtIndex(destIndex);
        setBookAtIndex(originIndex, dest);
        other.setBookAtIndex(destIndex, origin);
    }

    //STM
    public void atomicSwap(Shelf other, int originIndex, int destIndex) {
        StmUtils.atomic(() -> swap(other, originIndex, destIndex));
    }
}
