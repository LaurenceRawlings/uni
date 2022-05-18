/**
 * Rect.java
 *
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Rect is a rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle's bounding rectangle
 */
public class Rect extends ClosedShape {
    private int width, height; //The width and height of the rectangle (major and minor axis)

    /**
     * Creates a rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle (in pixels).
     * @param height The height of the rectangle (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     * @param doesPulse True if the rectangle will pulse.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean doesPulse) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, doesPulse);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a rectangle to a string.
     */
    public String toString() {
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width Resets the width of the rectangle.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return The height of the rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height Resets the height of the rectangle.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Draw the rectangle.
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, width, height);
        } else {
            g.strokeRect(x, y, width, height);
        }
    }
}
