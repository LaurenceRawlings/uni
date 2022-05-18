/**
 * Square.java
 *
 * @version 1.0.0
 * @author Laurence Rawlings
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */

public class Square extends ClosedShape {
    private int side; //The length of the square's side

    /**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param doesPulse True if the square will pulse.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean doesPulse) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, doesPulse);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString() {
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @param side Resets the side of the square.
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * @param  width Resets the side of the square.
     */
    public void setWidth(int width) {
        this.side = width;
    }

    /**
     * @return The height of the square.
     */
    public int getHeight() {
        return side;
    }

    /**
     * @param height Resets the side of the square.
     */
    public void setHeight(int height) {
        this.side = height;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }
    }
}
