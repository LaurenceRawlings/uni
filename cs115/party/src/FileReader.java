/**
 * FileReader.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Static functions used to read in data from text files and convert them into the required data structures
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    /**
     * Attempts to open the specifies profiles file, if it doesn't exist the program will exit, if it does call the
     * method to read in the profiles
     *
     * @param filename path to the profiles file
     * @return a BST containing all the profiles listed in the specified profiles file
     */
    public static BST readProfileSet(String filename) {
        File file = new File(filename);
        Scanner in = null;

        try {
            in = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
            System.exit(0);
        }

        return readProfileSet(in);
    }

    /**
     * Reads in the profiles from the file specified by the passed in scanner
     *
     * @param in a scanner that points to a file that definitely exists
     * @return a BST containing all the profiles listed in the specified profiles file
     */
    private static BST readProfileSet(Scanner in) {
        BST tree = new BST();

        while (in.hasNextLine()) {
            tree.insertProfile(createProfile(in.nextLine().split(",")));
        }

        in.close();
        return tree;
    }

    /**
     * Creates a profile object using the passed in array containing the data for the profile
     *
     * @param data array of profile data
     * @return the created profile object
     */
    private static Profile createProfile(String[] data) {
        String[] interests = new String[0];
        if (data.length == 10) {
            interests = data[9].split(";");
        }

        Profile p = new Profile(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                Integer.parseInt(data[4]), data[5], data[6], data[7], data[8], interests);
        return p;
    }

    /**
     * Attempts to open the specifies friends file, if it doesn't exist the program will exit, if it does call the
     * method to read in the friend links
     *
     * @param filename path to the friends file
     * @return an array list containing string arrays representing the friend links
     */
    public static ArrayList<String[]> readFriendSet(String filename) {
        File file = new File(filename);
        Scanner in = null;

        try {
            in = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
            System.exit(0);
        }

        return readFriendSet(in);
    }

    /**
     * Reads in the friend links from the file specified by the passed in scanner
     *
     * @param in a scanner that points to a file that definitely exists
     * @return an array list containing string arrays representing the friend links
     */
    private static ArrayList<String[]> readFriendSet(Scanner in) {
        ArrayList<String[]> friends = new ArrayList<>();

        while (in.hasNextLine()) {
            friends.add(in.nextLine().split(","));
        }

        in.close();
        return friends;
    }
}
