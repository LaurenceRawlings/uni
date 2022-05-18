public class Country {
    private String name;
    private HighPoint highestPoint;

    private static final String TO_STRING_MESSAGE = "The highest point in %s is %s which is %.3fm above sea level.";

    public Country(String name, HighPoint highestPoint) {
        this.name = name;
        this.highestPoint = highestPoint;
    }

    public String getName() {
        return name;
    }

    public HighPoint getHighestPoint() {
        return highestPoint;
    }

    public String toString() {
        return String.format(TO_STRING_MESSAGE,
                getName(), getHighestPoint().getName(), getHighestPoint().getHeight());
    }
}
