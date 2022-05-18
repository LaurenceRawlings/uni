//Completed up to Level 3

import java.util.Scanner;

public class LastBiscuit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int barrel1 = 6;        //Create and set number of biscuits in barrel 1 to 6
        int barrel2 = 8;        //Create and set number of biscuits in barrel 2 to 8
        int player = 1;         //Create and set the current player to 1
        boolean won = false;    //Create and set the game state to NOT won

        //Initialize the constant variables for the output messages
        //I used %d so that I can format the strings when I output them to insert custom numbers, like the current
        //player, number of biscuits and the barrel number. This minimises the amount of final variables needed
        final String MSG_BISCUITS_LEFT = "Biscuits Left - Barrel %d: %d";
        final String MSG_WHICH_BARREL = "From barrel1 (one), barrel2 (two), or both (both)? ";
        final String MSG_BISCUITS_TAKEN = "Biscuits taken by player %d: ";
        final String MSG_WINNER = "Winner is player %d";
        final String MSG_INVALID_INPUT = "That was an invalid input, try again.";
        final String MSG_INVALID_OPTION = "There are not enough biscuits for that, try again.";

        //Initially show how many biscuits are in each barrel before the game starts
        System.out.println(String.format(MSG_BISCUITS_LEFT, 1, barrel1));
        System.out.println(String.format(MSG_BISCUITS_LEFT, 2, barrel2));

        while (!won) {
            //These 3 variables are created inside the loop because they will only be used on the current turn
            //Create validOption to hold the truth whether the overall biscuit number and barrel choice is valid
            boolean validOption = false;

            int biscuitsTaken = 0;  //Number of biscuits to take chosen by the player, initially set to 0
            String whichBarrel;     //Initialize the barrel choice variable

            //This loop surrounds the combination of the 2 inputs that make upa the players turn, if they make an
            //invalid turn then the loop will be run again
            do {
                boolean validInput = false; //validInput is initially set to false and eventually changed to true if the
                //player inputs a valid choice.

                //I used do-while loops because I always want to ask for the input at least once
                do {
                    System.out.print(String.format(MSG_BISCUITS_TAKEN, player));
                    String input = in.nextLine();   //Initially store this as a string
                    try {
                        //Try to parse the string to an integer and save it to biscuitTaken, if the string the player
                        //input was not a string this will cause an error and will be caught and the code in the
                        //catch block will be run
                        biscuitsTaken = Integer.parseInt(input);
                        if (biscuitsTaken > 0) {    //Now we know the input was an integer, check if it is greater than 0
                            validInput = true;
                        } else {
                            System.out.println(MSG_INVALID_INPUT);
                        }
                    } catch (Exception e) { //Catch block will catch the error if the input was not an integer
                        System.out.println(MSG_INVALID_INPUT);
                    }
                } while (!validInput);  //validInput will still be false if the players input was not a positive
                // integer. Loop will run again

                validInput = false;
                do {
                    System.out.print(String.format(MSG_WHICH_BARREL));
                    whichBarrel = in.nextLine();

                    //If they picked one of the allowed inputs set validInput to true so the loop will not run again
                    //Otherwise output the error message and the loop will run again
                    if (whichBarrel.equals("one") || whichBarrel.equals("two") || whichBarrel.equals("both")) {
                        validInput = true;
                    } else {
                        System.out.println(MSG_INVALID_INPUT);
                    }
                } while (!validInput);  //validInput will still be false if the players input was not one of the
                // three options. Loop will run again

                //Depending on which barrel the player has picked, check if the number of biscuits they want to take is
                //less than or equal to the number of biscuits in that barrel or in both barrels
                //If the number of biscuits they want to take is valid then subtract that number from the barrel(s) that
                //they chose. Then set validOption to true so the do-while loop will stop, Otherwise present the
                //error message and the loop will run again.
                switch (whichBarrel) {
                    case "one":
                        if (biscuitsTaken <= barrel1) {
                            barrel1 -= biscuitsTaken;
                            validOption = true;
                        } else {
                            System.out.println(MSG_INVALID_OPTION);
                        }
                        break;
                    case "two":
                        if (biscuitsTaken <= barrel2) {
                            barrel2 -= biscuitsTaken;
                            validOption = true;
                        } else {
                            System.out.println(MSG_INVALID_OPTION);
                        }
                        break;
                    case "both":
                        if (biscuitsTaken <= barrel1 && biscuitsTaken <= barrel2) {
                            barrel1 -= biscuitsTaken;
                            barrel2 -= biscuitsTaken;
                            validOption = true;
                        } else {
                            System.out.println(MSG_INVALID_OPTION);
                        }
                        break;
                }
            }
            while (!validOption); //validOption will still be false if the players inputs were illegal. Loop will run again

            //Output how many biscuits are left in each barrel after the players turn
            System.out.println(String.format(MSG_BISCUITS_LEFT, 1, barrel1));
            System.out.println(String.format(MSG_BISCUITS_LEFT, 2, barrel2));

            //If each of the barrels have no biscuits left that means the player that has just played took the last biscuit
            if (barrel1 == 0 && barrel2 == 0) {
                System.out.println(String.format(MSG_WINNER, player));   //Output the winner message
                won = true; //Set the game state to won. This will stop the while loop
            } else {
                //If the game is not yet won, then switch the current player to the other player
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }
        }
    }
}
