/**
 * BSTNode.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * The node object that stores a Profile object to be inserted into the BST
 */

public class BSTNode {
    private Profile data; //Reference to the profile being stored by this node
    private BSTNode l; //Reference to the left chile node
    private BSTNode r; //Reference to the right child node

    /**
     * Constructor creates a new BSTNode object
     *
     * @param data reference to the profile to be stored in the node
     */
    public BSTNode(Profile data) {
        this.data = data;
    }

    /**
     * Gets the profile stored by the node
     *
     * @return the profile held by the node
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * Gets the left chile node
     *
     * @return the left child node
     */
    public BSTNode getL() {
        return l;
    }

    /**
     * Sets the left child node
     *
     * @param l the node to be set as the left child
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * Gets the right chile node
     *
     * @return the right child node
     */
    public BSTNode getR() {
        return r;
    }

    /**
     * Sets the right child node
     *
     * @param r the node to be set as the right child
     */
    public void setR(BSTNode r) {
        this.r = r;
    }


}
