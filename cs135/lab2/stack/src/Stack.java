public class Stack {

    static int stackSize = 5;

    static int topOfStack = -1;
    static int[] stack = new int[stackSize];
    static boolean errorFree = true;

    public static boolean isEmpty () {
        return topOfStack == -1;
    }

    public static boolean isFull () {
        return topOfStack == stackSize - 1;
    }

    public static void empty () {
        errorFree = true;
        topOfStack = -1;
    }

    public static int top () {
	errorFree = ! (isEmpty ()) & errorFree;
        if (errorFree) {
	        return stack[topOfStack];
	    } else {
	        return 0;
        } 
    }

    public static void push (int value) {
	errorFree = ! (isFull ()) & errorFree;
        if (errorFree) {
	    topOfStack = topOfStack + 1;
            stack[topOfStack] = value;	   
	} 
    }

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
}

}

