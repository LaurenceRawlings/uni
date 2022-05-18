/**
 * BSTNodeMain.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Tests BSTNode.java
 */

public class BSTNodeMain {

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

        test.addFriend(test2);

        BSTNode node = new BSTNode(test);
        BSTNode node2 = new BSTNode(test2);
        BSTNode node3 = new BSTNode(test3);

        node.setL(node2);
        node.setR(node3);

        System.out.println(node.getProfile().toString());
        System.out.println(node.getL().getProfile().toString());
        System.out.println(node.getR().getProfile().toString());
    }
}
