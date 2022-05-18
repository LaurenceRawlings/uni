/**
 * Circle.java
 *
 * @version 1.0.0
 * @author Laurence Rawlings
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding square.
 */
public class Circle extends ClosedShape {
    private int diameter; //The diameter of the circle

    /**
     * Creates a circle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param doesPulse True if the circle will pulse.
     */
    public Circle(int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean doesPulse) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, doesPulse);
        this.diameter = diameter;
    }

    /**
     * Method to convert a circle to a string.
     */
    public String toString() {
        String result = "This is a circle\n";
        result += super.toString();
        result += "Its diameter is " + this.diameter + "\n";
        return result;
    }

    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * @param diameter Resets the diameter of the circle.
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /**
     * @return The width of the circle
     */
    public int getWidth() {
        return diameter;
    }

    /**
     * @param width Resets the diameter of the circle.
     */
    public void setWidth(int width) {
        this.diameter = width;
    }

    /**
     * @return The height of the circle
     */
    public int getHeight() {
        return diameter;
    }

    /**
     * @param height Resets the diameter of the circle.
     */
    public void setHeight(int height) {
        this.diameter = height;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillOval(x, y, diameter, diameter);
        } else {
            g.strokeOval(x, y, diameter, diameter);
        }
    }
}
