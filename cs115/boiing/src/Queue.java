/**
 * Queue.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 */

import java.util.NoSuchElementException;

/**
 * This my own implementation of a simple queue.
 * @param <T> The type of object the queue will store.
 */
public class Queue<T> {
    private QueueElement<T> head;
    private QueueElement<T> tail;

    /**
     * Constructs an empty Queue.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Returns true if the queue is empty, otherwise returns false
     */
    public boolean isEmpty() {
        if (head == null || tail == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the element at the head of the queue
     */
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }

    /**
     * Removes the front element of the queue
     */
    public void dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            head = head.getNext();
        }
    }

    /**
     * Puts an element on the back of the queue.
     */
    public void enqueue(T element) {
        QueueElement<T> toQueue = new QueueElement<>(element, null);
        if (isEmpty()) {
            head = toQueue;
            tail = toQueue;
        } else {
            tail.setNext(toQueue);
            tail = toQueue;
        }
    }

    /**
     * Method to print the full contents of the queue in order from head to tail.
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        QueueElement<T> currentItem = head;

        while (currentItem.getNext() != null) {
            System.out.println(currentItem.getElement());
            currentItem = currentItem.getNext();
        }

        System.out.println(currentItem.getElement());
    }
}
