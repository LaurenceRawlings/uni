public class Clipper { 

    public static int clip(int lower, int upper, int x) {
        if (x < lower) {
            x = lower;
        }
        if (x > upper) {
            x = upper;
        }
        return x;
    }

}