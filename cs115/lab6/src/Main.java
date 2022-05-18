public class Main {

    public static void main(String[] args) {
        Tree<String> myTree = new Tree<>(new Node("Lin"));

        myTree.getRoot().setLeft(new Node("Howl"));
        myTree.getRoot().setRight(new Node("San"));

        myTree.getRoot().getLeft().setLeft(new Node("Calcifer"));
        myTree.getRoot().getLeft().setRight(new Node("Kiki"));

        myTree.getRoot().getRight().setLeft(new Node("Ponyo"));
        myTree.getRoot().getRight().setRight(new Node("Sophie"));
    }
}
