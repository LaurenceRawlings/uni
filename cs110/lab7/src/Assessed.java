import java.util.Scanner;

public class Assessed {
    public static void main(String[] args){
        System.out.print("Input a roman numeral: ");
        Scanner in = new Scanner(System.in);
        System.out.println(romanNumeralsToInt(in.nextLine()));
    }

    public static int romanNumeralToInt(char numeral){
        int returnInt = 0;
        switch (numeral){
            case 'I':
                returnInt = 1;
                break;
            case 'V':
                returnInt = 5;
                break;
            case 'X':
                returnInt = 10;
                break;
            case 'L':
                returnInt = 50;
                break;
            case 'C':
                returnInt = 100;
                break;
            case 'D':
                returnInt = 500;
                break;
            case 'M':
                returnInt = 1000;
                break;
            default:
                break;

        }
        return returnInt;
    }

    public static int romanNumeralsToInt(String input){
        int total = 0;
        for (int i = 0; i < input.length(); i++){
            total += romanNumeralToInt(input.charAt(i));
        }
        return total;
    }
}
