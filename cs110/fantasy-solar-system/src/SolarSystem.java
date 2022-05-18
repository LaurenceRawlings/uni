//Response to Personal Feedback
/*In my feedback for the last biscuit assignment the only section I lost marks on was for commenting. I was told that
my code was "too heavily commented", to improve this time I have written less comments and only commented parts that
require explanation.*/

//Response to Personal Feedback
/*Most of what was said in the general feedback I had followed in my Assignment 1. A couple of this that I can take into
consideration in the future:
Where I used 1 and -1 for player 1 and 2 I should have used a boolean instead. I did this so I could easily flip between
    both by multiplying by -1, however the same can be done with booleans e.g. someBoolean = !someBoolean

Another thing were my comments, this time I have commented logical blocks instead of adding comments at the end of lines,
    except for variable names where this makes sense to do so. I have also split my code up into regions which I have
    labelled. Finally, I do not explain anything that does not require explanation.*/

//region Imported Libraries
import java.text.DecimalFormat;
import java.util.ArrayList;
//endregion

public class SolarSystem {
    //region Variables
    DecimalFormat formatter = new DecimalFormat();

    private ArrayList<Planet> planets = new ArrayList<>();  //List of all planets in the solar system
    private final String name;          //The solar system's name
    private final double luminosity;    //The brightness of the solar system's star

    private static final String OUTPUT_MESSAGE = "Planet %s has a mass of %s Earths, is %sAU from its star, and orbits " +
            "in %s years: could be habitable? %s\n";

    //Constant values used to determine if a planet is habitable
    private static final double LOWEST_MASS = 0.6;
    private static final double HIGHEST_MASS = 7.0;

    private static final double LOWEST_DIST = 0.75;
    private static final double HIGHEST_DIST = 2.0;
    //endregion

    //Constructor
    public SolarSystem(String name, double luminosity) {
        this.name = name;
        this.luminosity = luminosity;

        //Required output needs decimal vales to 3 decimal places or fewer. Whole numbers should still have 1
        //decimal place e.g 1 => 1.0
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(3);
    }

    //region Get/Set Methods
    //Never used but good practise to include
    public String getName() {
        return name;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void addPlanet(String name, double mass, double distance) {
        planets.add(new Planet(name, mass, distance));
    }
    //endregion

    //region Methods/Functions
    public String toString() {
        //Here I use a string builder as using '+=' would create a copy of the string each time
        StringBuilder sb = new StringBuilder();

        sb.append(name + "\n");     //First start with the name of the solar system followed by a new line
        //Then for each planet in the solar system append the planets' details
        for (Planet planet : planets) {
            sb.append(String.format(OUTPUT_MESSAGE,
                    planet.getName(),
                    formatter.format(planet.getMass()),
                    formatter.format(planet.getDistance()),
                    formatter.format(planet.getOrbitalPeriod()),
                    planet.isHabitable() ? "yes" : "no")); //Ternary operator used to convert true and false to yes and no
        }

        return sb.toString();
    }
    //endregion

    //Planet is a subclass of SolarSystem, seemed logical as planets belong inside solar systems
    class Planet {
        //region Variables
        private String name;        //Planet's name
        private double mass;        //Planet's mass
        private double distance;    //Planet's distance from the solar systems sun
        //endregion

        //Constructor
        public Planet(String name, double mass, double distance) {
            this.name = name;
            setMass(mass);
            setDistance(distance);
        }

        //region Get/Set Methods
        public void setMass(double mass) {
            this.mass = mass;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public double getMass() {
            return mass;
        }

        public double getDistance() {
            return distance;
        }

        public double getOrbitalPeriod() {
            double period = Math.sqrt(distance * distance * distance);
            return period;
        }
        //endregion

        //region Methods/Functions
        public boolean isHabitable() {
            if (mass >= LOWEST_MASS && mass <= HIGHEST_MASS && distance >= (LOWEST_DIST * Math.sqrt(getLuminosity())) &&
                    distance <= (HIGHEST_DIST * Math.sqrt(getLuminosity()))) {
                return true;
            } else {
                return false;
            }
        }
        //endregion
    }
}
