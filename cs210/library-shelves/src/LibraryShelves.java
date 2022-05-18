/**
 * CS210 Lab Cass 4
 *
 * @author Laurence Rawlings (991368)
 */
public class LibraryShelves {
    public static void main(String[] args) throws InterruptedException {
        Swapper.STM = true;

        Shelf shelfA = new Shelf(5, 98);
        Shelf shelfB = new Shelf(5, 54);

        Swapper swapper1 = new Swapper("swapper1", shelfA, shelfB);
        Swapper swapper2 = new Swapper("swapper2", shelfB, shelfA);

        Thread t1 = new Thread(swapper1);
        Thread t2 = new Thread(swapper2);

        t1.start();
        t2.start();

        Thread.sleep(10000);

        t1.interrupt();
        t2.interrupt();

        t1.join();
        t2.join();
    }
}

/*
Task 1
This implementation may lead to a deadlock as it meets the Coffman conditions:
    Mutual Exclusion - The Swapper requires exclusive access to the shelves
    Hold and wait - The Swapper can acquire and hold ShelfA while waiting to acquire ShelfB
    No pre-emption - Also the process itself is solely responsible for releasing the shelves
    Circular wait - If swapper1 acquires ShelfA and locks it and simultaneously swapper2 acquires and locks ShelfB
                        then both swappers will both be stuck in state where they are trying to acquire the other
                        shelf but they can't. This is a circular wait.

Task 4
Pros of STM:
+ STM performance is optimal as it completes modifications to shared memory without worrying about other threads
+ Threads can modify disjoint parts of data structures safely without having to wait for access to the resource

Cons of STM:
- When using STM the transaction manager cannot perform any task that cannot be undone like most I/O operations
- Incomplete transactions can read incomplete states where it reads a mixture of old and new values written
    by another transaction.
 */