package core;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * Static methods for image processing.
 *
 * @author Laurence Rawlings (991368)
 * Declaration: I declare that this is my own code.
 */
public class ImageProcessor {
    public static WritableImage resize(WritableImage input, double scale) {
        return resize(input, scale, scale);
    }

    public static WritableImage resize(WritableImage input, double xScale,
                                       double yScale) {
        assert xScale != 0 && yScale != 0;
        int width = (int) Math.floor(input.getWidth() * xScale);
        int height = (int) Math.floor(input.getHeight() * yScale);

        WritableImage output = new WritableImage(width, height);

        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, bilinearInterpolate(input, x / xScale,
                        y / yScale));
            }
        }

        return output;
    }

    private static Color bilinearInterpolate(WritableImage image,
                                             double x, double y) {
        PixelReader reader = image.getPixelReader();

        if (x == (int) x && y == (int) y) {
            return reader.getColor((int) x, (int) y);
        }

        /*
        (x1,y1)  (x2,y1)
               .
        (x1,y2)  (x2,y2)
         */

        int x1 = (int) Math.floor(x);
        int y1 = (int) Math.floor(y);

        int x2 = x1 + 1;
        int y2 = y1 + 1;

        if (x2 > image.getWidth() - 1) {
            x2 = x1 - 1;
        }

        if (y2 > image.getHeight() - 1) {
            y2 = y1 - 1;
        }

        /*
        (c1)  (c2)
            .
        (c3)  (c4)
         */

        Color c1 = reader.getColor(x1, y1);
        Color c2 = reader.getColor(x2, y1);
        Color c3 = reader.getColor(x1, y2);
        Color c4 = reader.getColor(x2, y2);

        return linearInterpolate(
                linearInterpolate(c1, c2, x), linearInterpolate(c3, c4, x), y);
    }

    private static Color linearInterpolate(Color c1, Color c2, double weight) {
        weight = weight - Math.floor(weight);

        double r = c1.getRed() * (1 - weight) + c2.getRed() * weight;
        double g = c1.getBlue() * (1 - weight) + c2.getBlue() * weight;
        double b = c1.getGreen() * (1 - weight) + c2.getGreen() * weight;

        return new Color(r, g, b, 1.0);
    }
}
