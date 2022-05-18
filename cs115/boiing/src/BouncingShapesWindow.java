/**
 * BouncingShapeWindow.java
 *
 * @author Dr D. Archambault, Modified  for JAVAFX by Dr J. L. Jones
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;

public class BouncingShapesWindow {
    private static final int ANIMATION_DELAY = 10;
    private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";

    private GraphicsContext gc;
    private Queue<ClosedShape> shapesToAdd;
    private ArrayList<ClosedShape> activeShapes;
    private int currentTime = 0;
    private boolean flag = true;

    private String filename;

    public BouncingShapesWindow(GraphicsContext gc, String filename) {
        this.gc = gc;

        activeShapes = new ArrayList<ClosedShape>();
        this.initShapes(filename);
        this.insertShapes();
        drawClosedShapes();
        actionPerformed();
    }

    private void drawClosedShapes() {
        for (ClosedShape s : activeShapes) {
            if (currentTime % 100 == 0) {
                if (s.isDoesPulse()) {
                    if (s.isPulseState()) {
                        s.setWidth(s.getWidth() / 2);
                        s.setHeight(s.getHeight() / 2);
                        s.setPulseState(false);
                    } else {
                        s.setWidth(s.getWidth() * 2);
                        s.setHeight(s.getHeight() * 2);
                        s.setPulseState(true);
                    }
                }
            }
            s.draw(gc);
        }
    }

    private void initShapes(String filename) {
        shapesToAdd = ReadShapeFile.readDataFile(filename);
    }

    private void insertShapes() {
        //no more shapes to add, we are done
        if (shapesToAdd.isEmpty()) {
            return;
        }

        //add shapes if needed
        ClosedShape current = shapesToAdd.peek();
        while (!shapesToAdd.isEmpty() && (current.getInsertionTime() <= currentTime * ANIMATION_DELAY)) {
            activeShapes.add(current);
            shapesToAdd.dequeue();
            if (!shapesToAdd.isEmpty()) {
                current = shapesToAdd.peek();
            }
        }
    }

    public void actionPerformed() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> onTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void onTime() {
        currentTime++;
        double h = gc.getCanvas().getHeight();
        double w = gc.getCanvas().getWidth();
        gc.clearRect(0, 0, w, h);
        moveShapes();
        insertShapes();
        drawClosedShapes();
    }

    public void moveShapes() {
        double dimsY = gc.getCanvas().getHeight();
        double dimsX = gc.getCanvas().getWidth();
        for (ClosedShape s : activeShapes) {
            s.move();

            // Move us back in and bounce if we went outside the drawing area.
            if (s.outOfBoundsX(dimsX)) {
                s.putInBoundsX(dimsX);
                s.bounceX();
            }

            if (s.outOfBoundsY(dimsY)) {
                s.putInBoundsY(dimsY);
                s.bounceY();
            }

        }
    }

}

