import java.util.Scanner;

public class Assessed {
    public static void main(String[] args){
        String[] names = new String[10];
        Integer[] ages = new Integer[10];

        boolean run = true;
        Scanner in = new Scanner(System.in);
        int count = 0;

        do{
            if (count <= 10){
                System.out.print("Enter your name: ");
                String name  = in.nextLine();

                if (name.equals("done")){
                    run = false;

                } else{
                    System.out.print("Enter your age: ");
                    int age  = in.nextInt();
                    in.nextLine();
                    names[count] = name;
                    ages[count] = age;
                    count++;
                }
            } else{
                run = false;
            }
        }while(run);

        int min = 0;
        int max = 0;

        System.out.println();

        for (int i = 0; i < count; i++){
            if (ages[i] >= ages[max]){
                max = i;
            }
            if (ages[i] <= ages[min]){
                min = i;
            }

            System.out.println(names[i] + " is " + ages[i] + " years old");
        }

        System.out.println("\nThe youngest is " + names[min]);
        System.out.println("The oldest is " + names[max]);
    }
}
