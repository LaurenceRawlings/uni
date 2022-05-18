import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int oddSumMax;
        int sum = 0;

        do {
            System.out.print("Enter the maximum odd number: ");
            oddSumMax = input.nextInt();
            input.nextLine();
        } while (oddSumMax % 2 == 0);

        for (int i = 1; i < oddSumMax + 1; i+=2){
            sum += i;
        }

        System.out.println(String.format("The sum of all odd numbers from 1 to %d is %d.", oddSumMax, sum));
    }
}
