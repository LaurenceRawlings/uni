public class AlphaMain {

    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("profiles.txt");
        tree.printAlphabetical();
    }
}
