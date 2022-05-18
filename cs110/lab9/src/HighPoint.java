public class HighPoint {
    private String placeName;
    private double height;

    public HighPoint(String placeName, double height) {
        this.placeName = placeName;
        this.height = height;
    }

    public String getName() {
        return placeName;
    }

    public double getHeight() {
        return height;
    }
}