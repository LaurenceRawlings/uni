/**
 * BSTMain.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Tests BST.java
 */

public class BSTMain {
    public static void main(String[] args) {
        Profile test = new Profile("Rawlings", "Laurence", 2, 6, 2000,
                "Orlingbury", "UK", "British", "lr@test.com",
                new String[]{"Programming", "Driving", "Music"});

        Profile test2 = new Profile("Plunkett", "Toby", 3, 7, 2000,
                "Gloucester", "UK", "British", "tp@test.com",
                new String[]{"Windsurfing", "Skating", "Music"});

        Profile test3 = new Profile("Grandfield", "Fraser", 4, 8, 2000,
                "Gloucester", "UK", "British", "fg@test.com",
                new String[]{"Skating", "Clubbing", "Music"});

        BST tree = new BST();

        tree.insertProfile(test);
        tree.insertProfile(test2);
        tree.insertProfile(test3);

        System.out.println(tree.getProfiles());

        System.out.println(tree.findProfile("Laurence Rawlings").toString());

        tree.printAlphabetical();
    }
}
