/**
 * <h1>Queue</h1>
 * <p>An implementation of a queue using fixed arrays.<br>
 *      - A simple program to show the uses and workings of a queue. Implements the simple functions of a queue including enqueue and dequeue</p>
 *
 * @author Laurence Rawlings, Maria Gurrero Quintana
 * - no copyright
 *
 * <p><b>Date Created: </b> 19/02/2019</p>
 * <p><b>Last Modified: </b> 24/02/2019</p>
 * <p><b>Version History: </b>1.0, 2.0 - comments added</p>
 *
 * @version 2.0
 */


public class Queue {
    private int front = queueSize - 1, back = queueSize - 1, length = 0;

    private int[] queue = new int[queueSize]; //A fixed array queue of size queueSize, in this case 5
    private boolean ERROR_FREE = true; //Boolean to deduce whether the array is error free

    private final static int queueSize = 5; //Private int stating the size of the array queue

    /**
     * checks if the queue is empty
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     * @return true if the queue is empty, false if it is not
     */
    public boolean isEmpty() {
        return length == 0;
    }


    /**
     * checks if the queue is full
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     * @return true if the queue is full, false if it is not
     */
    public boolean isFull() {
        return (length == queueSize);
    }


    /**
     * checks if the queue has had any errors
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     * @return the value of ERROR_FREE
     */
    public boolean isErrorFree() {
        return ERROR_FREE;
    }


    /**
     * empties the queue returning it to its initial state
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     */
    public void Empty() {
        front = queueSize - 1;
        back = queueSize - 1;
        length = 0;
        ERROR_FREE = true;
    }


    /* If the array is error free, reduce the array length by one.
     * Remove the integer at the front of the array
     */


    /**
     * remove the item from the front of the queue and returns it
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     * @return the int at the index indicated by the front variable in the queue array
     */
    public int dequeue() {
        ERROR_FREE = !(isEmpty()) & (ERROR_FREE);
        if (ERROR_FREE) {
            length--;

            /* If the front of the queue is at the last position of the array and an item
             * is dequeued, move the front position of the queue to the start of the array
             */

            if (front == queueSize - 1) {
                front = 0;
            } else {
                front++;
            }
            return queue[front];
        } else {
            return 0;
        }
    }


    /**
     * adds and item to the back of the queue
     * <p>  no side-effects </p>
     * <p>  not referentially transparent </p>
     * @param value is the int that is to be added to the back of the queue
     */
    public void enqueue(int value) {
        ERROR_FREE = !(isFull()) & ERROR_FREE;
        if (ERROR_FREE) {
            length++;

            /* If the back of the queue is at the last position of the array and an item is
             * dequeued, move the back position of the queue to the front of the array
             */

            if (back == queueSize - 1) {
                back = 0;
            } else {
                back++;
            }
            queue[back] = value;
        }
    }
}