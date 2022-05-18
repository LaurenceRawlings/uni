public class Tree<T> {
    private Node root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
