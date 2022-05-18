
/**
 * A class that tests if the queue is working properly.
 */

import java.util.NoSuchElementException;

public class QueueTester {

	public static void main(String[] args) {
		//Method to test the Queue class.  This will cover some of the inputs of the general
		//Queue.  However, you should test your Queue more extensively than this.

		Queue<String> q = new Queue<String> ();
		
		//Check that the queue is empty
		System.out.println ("Queue should be empty: " + q.isEmpty ());
		try {
			System.out.println (q.peek());
		}
		catch (NoSuchElementException e) {
			System.out.println ("q.peek () exception is thrown as expected.");
		}
		
		try {
			q.dequeue();
		}
		catch (NoSuchElementException e) {
			System.out.println ("q.dequeue () exception is thrown as expected.");
		}
		System.out.println ("Check no elements.");
		q.print ();
		
		//load three integers
		System.out.println ("Loading 3 Strings");
		q.enqueue (new String ("One"));
		q.enqueue (new String ("Two"));
		q.enqueue (new String ("Thirty-three"));
		System.out.println ("Is queue empty? " + q.isEmpty ());
		System.out.println ("Printing the strings:");
		q.print ();
		
		//Check two dequeues
		System.out.println ("Check top and dequeue.");
		q.print ();
		System.out.println ("Dequeue " + q.peek().toString());
		q.dequeue ();
		q.print ();
		System.out.println ("Dequeue " + q.peek().toString());
		q.dequeue ();
		q.print ();
		
		//Check pushes
		System.out.println ("Enqueue Four ");
		q.enqueue(new String ("Four"));
		q.print ();
		System.out.println ("Enqueue Six ");
		q.enqueue(new String ("Six"));
		q.print ();
		
		//Clear the queue
		System.out.println ("Clearing the queue");
		while (!q.isEmpty ()) {
			System.out.println ("Dequeue " + q.peek().toString());
			q.dequeue ();
		}
		System.out.println("Queue should be empty: " + q.isEmpty ());
		System.out.println("Check no elements.");
		q.print ();
		
		try {
			System.out.println (q.peek());
		}
		catch (NoSuchElementException e) {
			System.out.println ("q.peek () exception is thrown as expected.");
		}
		
		try {
			q.dequeue();
		}
		catch (NoSuchElementException e) {
			System.out.println ("q.dequeue () exception is thrown as expected.");
		}
	}

}
