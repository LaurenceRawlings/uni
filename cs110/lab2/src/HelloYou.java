import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.Scanner;

public class HelloYou {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Ask user their name and get it as input string.
        System.out.println("What is your name?");
        String firstName = input.nextLine();
        System.out.println("Hello " + firstName + "!");

        //Get start time of the JVM
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        long startTime= runtimeBean.getStartTime();
        Date startDate = new Date(startTime);

        //Ask the user their age, then print it out and show the start time of the JVM.
        System.out.println("So " + firstName + " how old are you?");
        int age = input.nextInt();
        System.out.println("You are " + age + ". I am just a computer program but you started me at " + startDate);
    }
}
