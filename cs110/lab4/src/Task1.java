import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int x = 0;

        System.out.print("Enter first number: ");
        try{
            x = input.nextInt();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        input.nextLine();

        System.out.print("Enter second number: ");
        int y = input.nextInt();
        input.nextLine();


        if (x > y){
            System.out.println(x + " is bigger.");
        } else if (x < y){
            System.out.println(y + " is bigger.");
        } else{
            System.out.println("They are equal.");
        }
    }

}
