import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the magnitude of the earthquake: ");
        double mag = input.nextDouble();
        input.nextLine();

        if (mag > 0){
            System.out.print("An earthquake with that magnitude is ");
            if (mag < 2){
                System.out.print("Micro: \nMicroearthquakes, not felt, or felt rarely. Recorded by seismographs.");

            } else if (mag < 3){
                System.out.print("Ver Minor: \nFelt slightly by some people. No damage to buildings.");

            } else if (mag < 4){
                System.out.print("Minor: \nOften felt by people, but very rarely causes damage. \nShaking of indoor objects can " +
                        "be noticeable.");

            } else if (mag < 5){
                System.out.print("Light: \nNoticeable shaking of indoor objects and rattling noises. \nFelt by most people " +
                        "in the affected area. Slightly felt outside. Generally causes none to minimal damage. \n" +
                        "Moderate to significant damage very unlikely. Some objects may fall off shelves or be knocked " +
                        "over.");

            } else if (mag < 6){
                System.out.print("Moderate: \nCan cause damage of varying severity to poorly constructed buildings. \n" +
                        "At most, none to slight damage to all other buildings. Felt by everyone.");

            } else if (mag < 7){
                System.out.print("Strong: \nDamage to a moderate number of well-built structures in populated areas. \n" +
                        "Earthquake-resistant structures survive with slight to moderate damage. Poorly designed \n" +
                        "structures receive moderate to severe damage. Felt in wider areas; up to hundreds of \n" +
                        "miles/kilometers from the epicenter. Strong to violent shaking in epicentral area.");

            } else if (mag < 8){
                System.out.print("Major: \nCauses damage to most buildings, some to partially or completely collapse \n" +
                        "or receive severe damage. Well-designed structures are likely to receive damage. Felt across \n" +
                        "great distances with major damage mostly limited to 250 km from epicenter.");

            } else if (mag < 10){
                System.out.print("Great: \nMajor damage to buildings, structures likely to be destroyed. Will cause \n" +
                        "moderate to heavy damage to sturdy or earthquake-resistant buildings. Damaging in large \n" +
                        "areas. Felt in extremely large regions.");

            } else if (mag >= 10){
                System.out.print("Meteoric: \nAt or near total destruction – severe damage or collapse to all buildings." +
                        " \nHeavy damage and shaking extends to distant locations. Permanent changes in ground topography.");

            }
        } else{
            System.out.print("That is not a valid magnitude on the Richter Scale.");
        }
    }
}
