/**
 * BST.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Binary search tree used to store users of the social network
 */

import java.util.ArrayList;

public class BST {
    private BSTNode root;

    /**
     * Constructor to create the BST object
     */
    public BST() {
    }

    /**
     * Inserts a profile object into the correct position in the BST
     * @param p the profile to be inserted
     */
    public void insertProfile(Profile p) {
        BSTNode node = new BSTNode(p);

        if (root == null) {
            root = node;
        } else {
            findInsertPos(root, node);
        }
    }

    /**
     * Recursive function used to find the correct insertion point in the BST for the passed in node object
     * @param node current node
     * @param sort node to be inserted
     */
    private void findInsertPos(BSTNode node, BSTNode sort) {
        int compare = sort.getProfile().getName().compareTo(node.getProfile().getName());

        if (compare <= 0) {
            if (node.getL() == null) {
                node.setL(sort);
            } else {
                findInsertPos(node.getL(), sort);
            }
        } else {
            if (node.getR() == null) {
                node.setR(sort);
            } else {
                findInsertPos(node.getR(), sort);
            }
        }
    }

    /**
     * Prints out each profile object in the BST, if its empty display the empty message
     */
    public void printAlphabetical() {
        if (root != null) {
            for (Profile p : inOrder(root, new ArrayList<Profile>())) {
                System.out.println(p.getName());
            }
        } else {
            System.out.println("Tree is Empty!");
        }
    }

    /**
     * Gets all the profiles in the BST
     * @return an ordered array list of profiles in the BST
     */
    public ArrayList<Profile> getProfiles() {
        return inOrder(root, new ArrayList<Profile>());
    }

    /**
     * Recursive function which performs an in order traversal on the BST
     * @param node current node
     * @param order cumulative array list to eventually be returned
     * @return an ordered array list of profiles in the BST
     */
    private ArrayList<Profile> inOrder(BSTNode node, ArrayList<Profile> order) {
        if (node == null) {
            return order;
        }
        inOrder(node.getL(), order);
        order.add(node.getProfile());
        inOrder(node.getR(), order);
        return order;
    }

    /**
     * Finds the profile using the passed in name
     * @param name full name of the profile to be found
     * @return the profile object
     */
    public Profile findProfile(String name) {
        return search(root, name);
    }

    /**
     * Recursive function that perfoms a binary search on the BST
     * @param node current node
     * @param name full name of the profile to be found
     * @return the profile object
     */
    private Profile search(BSTNode node, String name) {
        if (node.getProfile().getName().equals(name)) {
            return node.getProfile();
        }

        int compare = name.compareTo(node.getProfile().getName());

        if (compare <= 0) {
            if (node.getL() == null) {
                return null;
            } else {
                return search(node.getL(), name);
            }
        } else {
            if (node.getR() == null) {
                return null;
            } else {
                return search(node.getR(), name);
            }
        }
    }
}
