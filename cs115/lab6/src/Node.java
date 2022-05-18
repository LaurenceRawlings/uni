public class Node<T> {
    private Node left;
    private Node right;
    private T data;


    public Node(Node left, Node right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
