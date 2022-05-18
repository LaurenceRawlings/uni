/*
This is an example of the automatic testing process that you will use for the
second coursework. Like the coursework, this involves using a *test class*
that I will supply below. To use it, you need to write a class called:

EdiblePlant

and that class needs to have a constructor:

public EdiblePlant(String name) {...

and methods:

public String getName() {

public void setColour(String colour) {...

public String getColour() {...

public void setFruit(boolean isFruit) {..

public boolean isFruit() {...

All these methods are very simple - just one line (and so is the constructor).
Obviously, your EdiblePlant class needs variables (which should of course be
private) representing the plant's name, colour and if it's a fruit or not (so
two Strings and a boolean).

Once you've written your EdiblePlant class, then you should compile it *and*
the EdiblePlantTester class:

javac EdiblePlantTester.java EdiblePlant.java

This will generate *two* class files. Then you need to run it - the class with
the main method is EdiblePlantTester, so you need to type:

java EdiblePlantTester

If your code (a) compiles and (b) prints "Pass!" then you've done it right.


*/
public class EdiblePlantTester {


    public static void main(String[] args) {
        
        final String LEMON = "lemon";
        final String LEMON_COLOUR = "yellow";
        final String RED_ONION = "red onion";
        final String RED_ONION_COLOUR = "red";
                
        EdiblePlant lemon = new EdiblePlant(LEMON);
        lemon.setColour(LEMON_COLOUR);
        lemon.setFruit(true);
        
        EdiblePlant redOnion = new EdiblePlant(RED_ONION);
        redOnion.setColour(RED_ONION_COLOUR);
        redOnion.setFruit(false);
        
        if (lemon.getColour() == LEMON_COLOUR && lemon.getName() == LEMON &&
                lemon.isFruit() &&
                redOnion.getColour() == RED_ONION_COLOUR &&
                redOnion.getName() == RED_ONION &&
                !redOnion.isFruit()) {
            System.out.println("Pass!");
        }else {
            System.out.println("Fail!");
        }
    }
    
}
