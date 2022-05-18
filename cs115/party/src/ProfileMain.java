/**
 * ProfileMain.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Tests Profile.java
 */

public class ProfileMain {

    public static void main(String[] args) {
        Profile test = new Profile("Rawlings", "Laurence", 2, 6, 2000,
                "Orlingbury", "UK", "British", "lr@test.com",
                new String[]{"Programming", "Driving", "Music"});

        Profile test2 = new Profile("Plunkett", "Toby", 3, 7, 2000,
                "Gloucester", "UK", "British", "tp@test.com",
                new String[]{"Windsurfing", "Skating", "Music"});

        test.addFriend(test2);
        test2.addFriend(test);
        System.out.println(test.toString());
        System.out.println(test2.toString());
    }
}
