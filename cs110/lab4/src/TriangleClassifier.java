import java.util.Scanner;

public class TriangleClassifier {

    /**
     * The classifications of triangles.
     */
    public enum TriangleType {
        EQUILITERAL, ISOSCELES, SCALENE, NOT_A_TRIANGLE, OUT_OF_RANGE; 

        /**
         * Converts a triangle type to a nice string.
         * @param t The triangle type to print.
         * @return The string representation of the triangle type.
         */
        public static String convertTriangleType (TriangleType t){
            String s = null;
            switch (t) {
                case EQUILITERAL: {
                    s = "The triangle is equiliteral.";
                    break;
                }
                case ISOSCELES: {
                    s = "The triangle is isosceles."; 
                    break;
                }
                case SCALENE: { 
                    s = "The triangle is scalene.";
                    break;
                }
                case NOT_A_TRIANGLE: {
                    s = "This is not a triangle.";
                    break;
                }
                case OUT_OF_RANGE: {
                    s = "The values entered are out of range.";
                }
            }
            return s;
        }
    }
    
    /**
     * Checks if inputs are in range.
     * @param x The input to check.
     */
    private static Boolean isInRange (int x) {
        return (0 <= x & x <= 200); 
    }

    /**
     * Checks if the inputs form a triangle.
     * @param a Side 1 of the supposed triangle.
     * @param b Side 1 of the supposed triangle.
     * @param c Side 1 of the supposed triangle.
     * @return True if the sides form a triangle, false otherwise.
     */
    private static Boolean isTriangle (int a, int b, int c) {
        return (a < b + c) & (b < a + c) & (c < a + b);
    }

    /**
     * Classify a triangle.
     * @param a Side 1 of the supposed triangle.
     * @param b Side 1 of the supposed triangle.
     * @param c Side 1 of the supposed triangle.
     * @return The classification of the triangle.
     */
    public static TriangleType classify (int a, int b, int c) {
        if (isInRange(a) & isInRange(b) & isInRange(c)) {
            if (isTriangle(a, b, c)) {
                if (a == b & b == c) {
                    return TriangleType.EQUILITERAL;
                } else if (a !=b & a != c & b != c) {
                    return TriangleType.SCALENE;
                } else {
                    return TriangleType.ISOSCELES;
                }

            } else {
                return TriangleType.NOT_A_TRIANGLE;
            }
        } else {
            return TriangleType.OUT_OF_RANGE; 
        }
    }

    public static void main (String args[]) {

        // length of the triangle sides
        int a;
        int b;
        int c;

        // to store the classification result
        TriangleClassifier.TriangleType result;

        // Reading integers
        Scanner input = new Scanner(System.in);

        // read in the triangle
        System.out.print("Length of side A: ");
        a = input.nextInt();

        System.out.print("Length of side B: ");
        b = input.nextInt();

        System.out.print("Length of side C: ");
        c = input.nextInt();

        // classify the triangle
        result = TriangleClassifier.classify(a, b, c);

        // print the result to the screen
        System.out.println(TriangleClassifier.TriangleType.convertTriangleType(result));
    }   
}
