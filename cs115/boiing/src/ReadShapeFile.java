/**
 * ReadShapeFile.java
 *
 * @version 1.0.0
 * @author Laurence Rawlings
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 */

import javafx.scene.paint.Color;

import java.io.*;
import java.util.Scanner;

/**
 * This class is used to get the shape data from a text
 * file and convert them into shape objects and place them
 * into a queue.
 */
public class ReadShapeFile {
    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        while (in.hasNextLine()) {
            String[] currentShape = in.nextLine().split(" ");

            if (currentShape[0].equals("circle")) {
                ClosedShape shape = readCircle(currentShape);
                shapeQueue.enqueue(shape);
                System.out.println(shape.toString());
            } else if (currentShape[0].equals("oval")) {
                ClosedShape shape = readOval(currentShape);
                shapeQueue.enqueue(shape);
                System.out.println(shape.toString());
            } else if (currentShape[0].equals("square")) {
                ClosedShape shape = readSquare(currentShape);
                shapeQueue.enqueue(shape);
                System.out.println(shape.toString());
            } else if (currentShape[0].equals("rect")) {
                ClosedShape shape = readRect(currentShape);
                shapeQueue.enqueue(shape);
                System.out.println(shape.toString());
            } else if (currentShape[0].equals("triangle")) {
                ClosedShape shape = readTriangle(currentShape);
                shapeQueue.enqueue(shape);
                System.out.println(shape.toString());
            }
        }

        in.close();
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) {
        // HINT: You might want to open a file here.
        File file = new File(filename);
        Scanner in = null;

        try {
            in = new Scanner(file); //null is not sensible. Please change

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
            System.exit(0);
        }

        return ReadShapeFile.readDataFile(in);
    }

    /**
     * Creates a circle object using the raw data passed in.
     *
     * @param currentShape The data for the circle to be created.
     * @return The created circle.
     */
    private static Circle readCircle(String[] currentShape) {
        int r = Integer.parseInt(currentShape[7]);
        int g = Integer.parseInt(currentShape[8]);
        int b = Integer.parseInt(currentShape[9]);
        Color color = Color.rgb(r, g, b);
        boolean filled = false;
        if (currentShape[5].equals("true")) {
            filled = true;
        }
        int insertionTime = Integer.parseInt(currentShape[10]);
        int px = Integer.parseInt(currentShape[1]);
        int py = Integer.parseInt(currentShape[2]);
        int vx = Integer.parseInt(currentShape[3]);
        int vy = Integer.parseInt(currentShape[4]);
        int diameter = Integer.parseInt(currentShape[6]);

        boolean pulse = false;
        if (currentShape[11].equals("true")) {
            pulse = true;
        }

        return new Circle(insertionTime, px, py, vx, vy, diameter, color, filled, pulse);
    }

    /**
     * Creates an oval object using the raw data passed in.
     *
     * @param currentShape The data for the oval to be created.
     * @return The created oval.
     */
    private static Oval readOval(String[] currentShape) {
        int r = Integer.parseInt(currentShape[8]);
        int g = Integer.parseInt(currentShape[9]);
        int b = Integer.parseInt(currentShape[10]);
        Color color = Color.rgb(r, g, b);
        boolean filled = false;
        if (currentShape[5].equals("true")) {
            filled = true;
        }
        int insertionTime = Integer.parseInt(currentShape[11]);
        int px = Integer.parseInt(currentShape[1]);
        int py = Integer.parseInt(currentShape[2]);
        int vx = Integer.parseInt(currentShape[3]);
        int vy = Integer.parseInt(currentShape[4]);
        int width = Integer.parseInt(currentShape[6]);
        int height = Integer.parseInt(currentShape[7]);

        boolean pulse = false;
        if (currentShape[12].equals("true")) {
            pulse = true;
        }

        return new Oval(insertionTime, px, py, vx, vy, width, height, color, filled, pulse);
    }

    /**
     * Creates a square object using the raw data passed in.
     *
     * @param currentShape The data for the square to be created.
     * @return The created square.
     */
    private static Square readSquare(String[] currentShape) {
        int r = Integer.parseInt(currentShape[7]);
        int g = Integer.parseInt(currentShape[8]);
        int b = Integer.parseInt(currentShape[9]);
        Color color = Color.rgb(r, g, b);
        boolean filled = false;
        if (currentShape[5].equals("true")) {
            filled = true;
        }
        int insertionTime = Integer.parseInt(currentShape[10]);
        int px = Integer.parseInt(currentShape[1]);
        int py = Integer.parseInt(currentShape[2]);
        int vx = Integer.parseInt(currentShape[3]);
        int vy = Integer.parseInt(currentShape[4]);
        int diameter = Integer.parseInt(currentShape[6]);

        boolean pulse = false;
        if (currentShape[11].equals("true")) {
            pulse = true;
        }

        return new Square(insertionTime, px, py, vx, vy, diameter, color, filled, pulse);
    }

    /**
     * Creates a rectangle object using the raw data passed in.
     *
     * @param currentShape The data for the rectangle to be created.
     * @return The created rectangle.
     */
    private static Rect readRect(String[] currentShape) {
        int r = Integer.parseInt(currentShape[8]);
        int g = Integer.parseInt(currentShape[9]);
        int b = Integer.parseInt(currentShape[10]);
        Color color = Color.rgb(r, g, b);
        boolean filled = false;
        if (currentShape[5].equals("true")) {
            filled = true;
        }
        int insertionTime = Integer.parseInt(currentShape[11]);
        int px = Integer.parseInt(currentShape[1]);
        int py = Integer.parseInt(currentShape[2]);
        int vx = Integer.parseInt(currentShape[3]);
        int vy = Integer.parseInt(currentShape[4]);
        int width = Integer.parseInt(currentShape[6]);
        int height = Integer.parseInt(currentShape[7]);

        boolean pulse = false;
        if (currentShape[12].equals("true")) {
            pulse = true;
        }

        return new Rect(insertionTime, px, py, vx, vy, width, height, color, filled, pulse);
    }

    /**
     * Creates a triangle object using the raw data passed in.
     *
     * @param currentShape The data for the triangle to be created.
     * @return The created triangle.
     */
    private static Triangle readTriangle(String[] currentShape) {
        int r = Integer.parseInt(currentShape[7]);
        int g = Integer.parseInt(currentShape[8]);
        int b = Integer.parseInt(currentShape[9]);
        Color color = Color.rgb(r, g, b);
        boolean filled = false;
        if (currentShape[5].equals("true")) {
            filled = true;
        }
        int insertionTime = Integer.parseInt(currentShape[10]);
        int px = Integer.parseInt(currentShape[1]);
        int py = Integer.parseInt(currentShape[2]);
        int vx = Integer.parseInt(currentShape[3]);
        int vy = Integer.parseInt(currentShape[4]);
        int side = Integer.parseInt(currentShape[6]);

        boolean pulse = false;
        if (currentShape[11].equals("true")) {
            pulse = true;
        }

        return new Triangle(insertionTime, px, py, vx, vy, side, color, filled, pulse);
    }
}
