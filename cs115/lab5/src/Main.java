public class Main {

    public static void main(String[] args) {
	    LinkedList<String> myList  = new LinkedList<>();

	    myList.insertAt(0, "A");
        myList.insertAt(1, "B");
        myList.insertAt(2, "C");

        //myList.insertAt(4, "D");

        System.out.println(myList.toString());
        System.out.println(myList.elementAt(1));
        System.out.println(myList.elementAt(0));

        //System.out.println(myList.elementAt(3));

        myList.insertAt(1, "A2");
        System.out.println(myList.toString());
        System.out.println(myList.elementAt(3));

        myList.removeAt(0);
        System.out.println(myList.toString());
        System.out.println(myList.elementAt(2));

        //System.out.println(myList.elementAt(3));
        //myList.removeAt(3);

        myList.removeAt(2);
        System.out.println(myList.toString());



        //5.2
        LinkedList < String > strs = new LinkedList < String > ();
        LinkedList < Integer > ints = new LinkedList < Integer > ();
        //ints.insertAt(0 , "Hi there.");
        //Can't insert a string into the ints array because it is initialised with the generic type of Integer.

    }
}
