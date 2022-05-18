/**
 * <h1>Stack</h1>
 * <p>An implementation of a stack using fixed arrays.<br>
 *      - A simple program to show the uses and workings of a stack. Implements the simple functions of a stack including top, push and pop.</p>
 *
 * @author Laurence Rawlings, Maria Gurrero Quintana
 * - no copyright
 *
 * <p><b>Date Created: </b> 12/02/2019</p>
 * <p><b>Last Modified: </b> 12/02/2019</p>
 * <p><b>Version History: </b>1.0</p>
 *
 * @version 1.0
 */

public class Stack {

    static int stackSize = 5;

    static int topOfStack = -1;
    static int[] stack = new int[stackSize];
    static boolean errorFree = true;

	/**
	* <p>isEmpty checks if the stack is empty or not<br>
	* isEmpty is NOT referentially transparent<br>
	* @return returns true if the stack pointer topOfStack is -1 which means the stack is empty, otherwise returns false
	*/
    public static boolean isEmpty () {
        return topOfStack == -1;
    }

	/**
	* <p>isFull checks if the stack is full or not<br>
	* isFull is NOT referentially transparent<br>
	* @return returns true if the stack pointer topOfStack is the stack size minus 1 which means the stack is full, otherwise returns false
	*/
    public static boolean isFull () {
        return topOfStack == stackSize - 1;
    }

	/**
	* <p>empty resets the stack moving the stack pointer topOfStack back to -1 and resets errorFree back to true<br>
	* empty is NOT referentially transparent<br>
	*/
    public static void empty () {
        errorFree = true;
        topOfStack = -1;
    }

	/**
	* <p>top gets the item that is currently at the top of the stack and returns it<br>
	* top is NOT referentially transparent<br>
	* @return if the stack is not empty and there are currenty no errors then the item at the top of the stack is returned. Otherwise 0 is returned
	*/
    public static int top () {
	errorFree = ! (isEmpty ()) & errorFree;
        if (errorFree) {
	    return stack[topOfStack];
	} else {
	    return 0;
        } 
    }

	/**
	* <p>push add 1 to the top of stack pointer topOfStack and sets that position to the value passed in via the patrameter value<br>
	* push is NOT referentially transparent<br>
	* @param value is the integer that is to be added to the top of the stack
	*/
    public static void push (int value) {
	errorFree = ! (isFull ()) & errorFree;
        if (errorFree) {
	    topOfStack = topOfStack + 1;
            stack[topOfStack] = value;	   
	} 
    }

	/**
	* <p>pop takes 1 away from the top of stack pointer topOfStack changoing the value at the top of the stack<br>
	* this only happens if the stack is not empty and there are currently no errors<br>
	* top is NOT referentially transparent<br>
	*/
    public static void pop () {
	errorFree = ! (isEmpty ()) & errorFree;
        if (errorFree) {
	    topOfStack = topOfStack - 1;
	} 
    }

public static void main (String args[]) {
    int test;

    System.out.println(" --- Begin Experiment 1 ---");


    System.out.println(" --- Empty ---");
    empty ();

    System.out.println("Build up a stack of one entry:");
    push(1);
    System.out.println("   push 1");

    System.out.println("Inspect the stack:");
    test = top();
    System.out.println("   top: " + test);

    System.out.println("Make the stack empty:");
    pop();
    System.out.println("   pop");

    System.out.println("Test how 'top' works on the empty stack:");
    test = top();

    if (errorFree) {
       System.out.println("   top: " + test);
    } else {
       System.out.println("   An error has occured.");
    }

    System.out.println(" --- End Experiment 1 ---");

    System.out.println(" --- Begin Experiment 2 ---");

    System.out.println(" --- Empty ---");
    empty ();

    System.out.println("Build up a stack of five entries:");

    push(1);
    System.out.println("   push 1");
    push(2);
    System.out.println("   push 2");
    push(3);
    System.out.println("   push 3");
    push(4);
    System.out.println("   push 4");
    push(5);
    System.out.println("   push 5");

    System.out.println("Push another entry and check if 'out of memory'-protection works:");

    push(6);
    if (errorFree) {
           System.out.println("   push 6");
    } else {
       System.out.println("   An error has occured.");
    }

    System.out.println(" --- End Experiment 2 ---");


    System.out.println(" --- Begin Experiment 3 ---");

    empty ();
    System.out.println(" --- Empty ---");

    System.out.println("Build up a stack of three entries:");

    push(1);
    System.out.println("   push 1");
    push(2);
    System.out.println("   push 2");
    push(3);
    System.out.println("   push 3");

    System.out.println("Take these three entries away.");
    while (! isEmpty ()) {
        test = top ();
        System.out.println("   top: " + test);
        pop ();
        System.out.println("   pop");
    }

    System.out.println(" --- End Experiment 3 ---");


    System.out.println(" --- Begin Experiment 4 ---");

    empty ();
    System.out.println(" --- Empty ---");

    System.out.println("Build up a stack of two entries:");

    push(25);
    System.out.println("   push 25");
    push(31);
    System.out.println("   push 31");

    System.out.println("Pop the top value.");
    pop();
    System.out.println("   pop");
    test = top ();
    System.out.println("   top: " + test);

    System.out.println(" --- End Experiment 4 ---");


    System.out.println(" --- Begin Experiment 5 ---");

    empty ();
    System.out.println(" --- Empty ---");

    System.out.println("Start with an empty stack and push one entry:");

    System.out.println("   stack is" + (isEmpty() ? " " : " not ") + "empty");

    push(42);
    System.out.println("   push 42");

    System.out.println("   stack is" + (isEmpty() ? " " : " not ") + "empty");


    System.out.println("Pop a value.");
    pop();
    System.out.println("   pop");

    System.out.println("   stack is" + (isEmpty() ? " " : " not ") + "empty");

    System.out.println(" --- End Experiment 5 ---");
}

}

