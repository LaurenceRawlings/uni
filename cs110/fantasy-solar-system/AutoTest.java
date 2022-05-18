
//Uncomment if using extra tests
//import org.apache.commons.lang3.StringUtils;

/*This is the automatic test class for CS-110 coursework 2. The output of the student's program
 * under test should match the string TARGET_OUTPUT_SUN
 */
public class AutoTest {

    static final String TARGET_OUTPUT_SUN = "Our System\n"
            + "Planet Mercury has a mass of 0.055 Earths, is 0.387AU from its star, and orbits in 0.241 years: could be habitable? no\n"
            + "Planet Venus has a mass of 0.815 Earths, is 0.723AU from its star, and orbits in 0.615 years: could be habitable? no\n"
            + "Planet Earth has a mass of 1.0 Earths, is 1.0AU from its star, and orbits in 1.0 years: could be habitable? yes\n"
            + "Planet Mars has a mass of 0.107 Earths, is 1.52AU from its star, and orbits in 1.874 years: could be habitable? no\n"
            + "Planet Jupiter has a mass of 317.8 Earths, is 5.2AU from its star, and orbits in 11.858 years: could be habitable? no\n"
            + "Planet Saturn has a mass of 95.2 Earths, is 9.58AU from its star, and orbits in 29.652 years: could be habitable? no\n"
            + "Planet Uranus has a mass of 14.5 Earths, is 19.2AU from its star, and orbits in 84.13 years: could be habitable? no\n"
            + "Planet Neptune has a mass of 17.1 Earths, is 30.05AU from its star, and orbits in 164.728 years: could be habitable? no\n";
    
    static final String TARGET_OUTPUT_TRAPPIST1 = "Trappist 1\n" +
            "Planet Trappist1b has a mass of 1.017 Earths, is 0.012AU from its star, and orbits in 0.001 years: could be habitable? no\n" +
            "Planet Trappist1c has a mass of 1.156 Earths, is 0.016AU from its star, and orbits in 0.002 years: could be habitable? no\n" +
            "Planet Trappist1d has a mass of 0.297 Earths, is 0.022AU from its star, and orbits in 0.003 years: could be habitable? no\n" +
            "Planet Trappist1e has a mass of 0.772 Earths, is 0.029AU from its star, and orbits in 0.005 years: could be habitable? yes\n" +
            "Planet Trappist1f has a mass of 0.934 Earths, is 0.038AU from its star, and orbits in 0.007 years: could be habitable? yes\n" +
            "Planet Trappist1g has a mass of 1.148 Earths, is 0.049AU from its star, and orbits in 0.011 years: could be habitable? yes\n" +
            "Planet Trappist1h has a mass of 0.331 Earths, is 0.062AU from its star, and orbits in 0.015 years: could be habitable? no\n";

    public static void main(String[] args) {
        
        
        //Create our solar system
        SolarSystem ourSystem = new SolarSystem("Our System",1.0);

        //Add planets in our solar system
        ourSystem.addPlanet("Mercury", 0.055, 0.387);
        ourSystem.addPlanet("Venus", 0.815, 0.723);
        ourSystem.addPlanet("Earth", 1.0, 1.0);
        ourSystem.addPlanet("Mars", 0.107, 1.52);
        ourSystem.addPlanet("Jupiter", 317.8, 5.20);
        ourSystem.addPlanet("Saturn", 95.2, 9.58);
        ourSystem.addPlanet("Uranus", 14.5, 19.20);
        ourSystem.addPlanet("Neptune", 17.1, 30.05);

        //Check the output for our solar system
        if (ourSystem.toString().equals(TARGET_OUTPUT_SUN)) {
            System.out.println("Solar System: Pass!");
        } else {
            System.out.println("Solar System: Fail!\n*****");
            System.out.println("Expected output:\n");
            System.out.println(TARGET_OUTPUT_SUN);
            System.out.println("\n\nActual output:\n");
            System.out.println(ourSystem.toString());
            // Uncomment if using extra tests*/
            /*System.out.println("\n\nDifferences:");
            System.out.println(StringUtils.difference(ourSystem.toString(),
            TARGET_OUTPUT_SUN));*/
        }
        
        System.out.println("\n\n");//blank lines to separate output
        
        //Create the Trappist1 system - a much dimmer star with closer planets
        SolarSystem trappist1 = new SolarSystem("Trappist 1",0.00128);

        //Add planets in Trappist 1 system
        trappist1.addPlanet("Trappist1b", 1.017, 0.012);
        trappist1.addPlanet("Trappist1c", 1.156, 0.016);
        trappist1.addPlanet("Trappist1d", 0.297, 0.022);
        trappist1.addPlanet("Trappist1e", 0.772, 0.029);
        trappist1.addPlanet("Trappist1f", 0.934, 0.038);
        trappist1.addPlanet("Trappist1g", 1.148, 0.049);
        trappist1.addPlanet("Trappist1h", 0.331, 0.062);

        //Check the output for trappist1
        if (trappist1.toString().equals(TARGET_OUTPUT_TRAPPIST1)) {
            System.out.println("Trappist1: Pass!");
        } else {
            System.out.println("Trappist1: Fail!\n*****");
            System.out.println("Expected output:\n");
            System.out.println(TARGET_OUTPUT_TRAPPIST1);
            System.out.println("\n\nActual output:\n");
            System.out.println(trappist1.toString());
            // Uncomment if using extra tests*/
            System.out.println("\n\nDifferences:");
            /*System.out.println(StringUtils.difference(ourSystem.toString(),
            TARGET_OUTPUT_TRAPPIST1));*/
        }
    }
}
