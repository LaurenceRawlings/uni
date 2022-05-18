/**
 * FileReaderMain.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Tests FileReader.java
 */

public class FileReaderMain {
    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("profiles.txt");
        tree.printAlphabetical();
    }
}
