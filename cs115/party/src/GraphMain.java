/**
 * GraphMain.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Tests Graph.java
 */

import java.util.ArrayList;

public class GraphMain {
    public static void main(String[] args) {
        BST b = FileReader.readProfileSet("profiles.txt");
        Graph g = new Graph("friends.txt", b);

        ArrayList<Profile> profiles = b.getProfiles();

        Profile[] tests = profiles.toArray(new Profile[profiles.size()]);

        BST[] recommendations = g.friendRecommendations(tests);

        int i = 0;
        for (BST recommendation : recommendations) {
            System.out.println("Friend recommendations for " + tests[i].getName() + ":");
            recommendation.printAlphabetical();
            System.out.println();
            i++;
        }
    }
}
