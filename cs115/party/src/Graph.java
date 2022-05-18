/**
 * Graph.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Used to recommend friends to users of the social network
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private BST profiles; //The BST for which the graph is to be created for

    /**
     * Constrictor to create the graph object
     * @param filename path to the file containing the friend links
     * @param profiles the BST for which the graph is to be created for
     */
    public Graph(String filename, BST profiles) {
        this.profiles = profiles;
        addFriends(filename);
    }

    /**
     * Uses the FileReader to get the friend links, then loops through each profile in the BST to add the friends from
     * the friend links to their respective profiles
     * @param filename path to the file containing the friend links
     */
    private void addFriends(String filename) {
        ArrayList<String[]> friends = FileReader.readFriendSet(filename);

        for (Profile p : profiles.getProfiles()) {
            for (String[] friend : friends) {
                if (p.getName().equals(friend[0])) {
                    Profile f = profiles.findProfile(friend[1]);
                    p.addFriend(f);
                    f.addFriend(p);
                }
            }
        }
    }

    /**
     * Used to recommend friends to users of the social network using the closed triadic structure method
     * @param users an array of profile objects for which friends are to be recommended to
     * @return an array of BSTs containing the recommended friends, one for each profile passed in
     */
    public BST[] friendRecommendations(Profile[] users) {
        boolean[][] matrix = generateMatrix(new ArrayList<>(Arrays.asList(users)));
        BST[] recommendations = new BST[users.length];

        int i = 0;
        for (Profile self : users) {
            BST recommendation = new BST();

            int j = 0;
            for (Profile friend : users) {
                if (matrix[i][j]) {
                    int k = 0;
                    for (Profile mutual : users) {
                        if (matrix[k][j] && !matrix[i][k]) {
                            if (self != mutual && friend != mutual) {
                                if (!recommendation.getProfiles().contains(mutual)) {
                                    recommendation.insertProfile(mutual);
                                }
                            }
                        }
                        k++;
                    }
                }
                j++;
            }
            recommendations[i] = recommendation;
            i++;
        }
        return recommendations;
    }

    /**
     * Generates a 2d matrix to store all of the friend links between the profiles passed in
     * @param users an array of profile objects for which the matrix is to be generated for
     * @return a 2d boolean array to symbolise who is friends with who
     */
    private boolean[][] generateMatrix(ArrayList<Profile> users) {
        boolean[][] matrix = new boolean[users.size()][users.size()];

        int i = 0;
        for (Profile p : users) {
            for (int j = 0; j < p.numOfFriends(); j++) {
                if (users.contains(p.getFriend(j))) {
                    matrix[i][users.indexOf(p.getFriend(j))] = true;
                }
            }
            i++;
        }

        return matrix;
    }
}
