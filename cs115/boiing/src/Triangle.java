/**
 * Triangle.java
 *
 * @version 1.0.0
 * @author Laurence Rawlings
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Triangle is a equilateral triangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * triangle's bounding square
 */
public class Triangle extends ClosedShape {
    private int side; //The length of the side of the equilateral triangle

    /**
     * Creates a triangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The length of the side of the equilateral triangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the triangle is filled with colour, false if opaque.
     * @param doesPulse True if the triangle will pulse.
     */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean doesPulse) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, doesPulse);
        this.side = side;
    }

    /**
     * @return The side of the triangle.
     */
    public int getSide() {
        return side;
    }

    /**
     * @param side Resets the side of the triangle.
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * @return The width of the triangle.
     */
    public int getWidth() {
        return this.side;
    }

    /**
     * @param width Resets the side of the triangle.
     */
    public void setWidth(int width) {
        this.side = width;
    }

    /**
     * @return The height of the triangle.
     */
    public int getHeight() {
        return side;
    }

    /**
     * @param height Resets the side of the triangle.
     */
    public void setHeight(int height) {
        this.side = height;
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its side is " + this.getSide() + "\n";
        return result;
    }

    /**
     * Draw the triangle.
     *
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);

        double xPoints[] = {x + (side / 2), x, x + side};
        double yPoints[] = {y, y + side, y + side};
        int nPoints = 3;

        if (isFilled) {
            g.fillPolygon(xPoints, yPoints, nPoints);
        } else {
            g.strokePolygon(xPoints, yPoints, nPoints);
        }
    }
}
