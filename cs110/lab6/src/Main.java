import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Scanner in = new Scanner(System.in);

        int num1;
        int num2;

        System.out.print("Enter number: ");
        num1 = in.nextInt();
        in.nextLine();
        System.out.print("Enter number: ");
        num2 = in.nextInt();
        in.nextLine();

        System.out.println(String.format("%d x %d = %d", num1, num2, num1*num2));
    }
}
