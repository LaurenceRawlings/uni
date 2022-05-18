package model;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;

/**
 * Model class for storing the volume data and performing algorithms on the
 * data.
 *
 * @author Laurence Rawlings (991368)
 * Declaration: I declare that this is my own code.
 */
public class CTData {
    private final int x;
    private final int y;
    private final int z;
    private final File file;
    private short[][][] ctData;
    private short min;
    private short max;
    private int[] histogram;
    private int[] cdf;

    public CTData(File file, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.file = file;
        resetMinMax();

        try {
            readData(x, y, z);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    private void readData(int x, int y, int z) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)));

        resetMinMax();
        short read;
        int byte1, byte2;

        ctData = new short[z][y][x];
        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    byte1 = ((int) in.readByte()) & 0xff;
                    byte2 = ((int) in.readByte()) & 0xff;
                    read = (short) ((byte2 << 8) | byte1);
                    if (read < min) min = read;
                    if (read > max) max = read;
                    ctData[k][j][i] = read;
                }
            }
        }

        fillHistogram();
    }

    private void fillHistogram() {
        histogram = new int[(max - min) + 1];

        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    histogram[ctData[k][j][i] - min]++;
                }
            }
        }

        calculateCdf();
    }

    private void calculateCdf() {
        cdf = new int[histogram.length];
        cdf[0] = histogram[0];
        for (int i = 1; i < histogram.length; i++) {
            cdf[i] = cdf[i - 1] + histogram[i];
        }
    }

    public WritableImage drawSlice(int slice, char axis, boolean he) {
        float colour;
        short datum;
        int width;
        int height;

        switch (axis) {
            case 'x':
                width = y;
                height = z;
                break;
            case 'y':
                width = x;
                height = z;
                break;
            default:
                width = x;
                height = y;
                break;
        }

        WritableImage image = new WritableImage(width, height);
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                switch (axis) {
                    case 'x':
                        datum = ctData[j][i][slice];
                        break;
                    case 'y':
                        datum = ctData[j][slice][i];
                        break;
                    default:
                        datum = ctData[slice][j][i];
                        break;
                }
                colour = calculateColour(datum, he);
                pixelWriter.setColor(i, j,
                        Color.color(colour, colour, colour, 1.0));
            }
        }

        return image;
    }

    public WritableImage drawMip(char axis, boolean he) {
        float colour;
        short datum;
        int width;
        int height;
        int depth;

        switch (axis) {
            case 'x':
                width = y;
                height = z;
                depth = x;
                break;
            case 'y':
                width = x;
                height = z;
                depth = y;
                break;
            default:
                width = x;
                height = y;
                depth = z;
                break;
        }

        WritableImage image = new WritableImage(width, height);
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int k = 0; k < height; k++) {
            for (int j = 0; j < width; j++) {
                short mipMax = Short.MIN_VALUE;
                for (int i = 0; i < depth; i++) {
                    switch (axis) {
                        case 'x':
                            datum = ctData[k][j][i];
                            break;
                        case 'y':
                            datum = ctData[k][i][j];
                            break;
                        default:
                            datum = ctData[i][k][j];
                            break;
                    }
                    if (datum > mipMax) {
                        mipMax = datum;
                        colour = calculateColour(datum, he);
                        pixelWriter.setColor(j, k,
                                Color.color(colour, colour, colour, 1.0));
                    }
                }
            }
        }

        return image;
    }

    private void resetMinMax() {
        min = Short.MAX_VALUE;
        max = Short.MIN_VALUE;
    }

    private float calculateColour(short datum, boolean he) {
        if (he) {
            return ((float) cdf[datum - min] /
                    ((float) x * (float) y * (float) z));
        } else {
            return (((float) datum - (float) min) / ((float) (max - min)));
        }
    }
}
