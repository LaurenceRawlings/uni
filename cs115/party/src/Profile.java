/**
 * Profile.java
 *
 * @author Laurence Rawlings
 * @version 1.0.0
 * <p>
 * Profile object to store details of a user in the social network
 */

import java.util.ArrayList;

public class Profile {
    private String lastName;
    private String firstName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String homeTown;
    private String homeCountry;
    private String nationality;
    private String email;
    private String[] interests;
    private ArrayList<Profile> friends; //List containing references to other profile objects that symbolise friends

    /**
     * Constructor creates a new profile object
     *
     * @param lastName
     * @param firstName
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     * @param homeTown
     * @param homeCountry
     * @param nationality
     * @param email
     * @param interests
     */
    public Profile(String lastName, String firstName, int birthDay, int birthMonth, int birthYear, String homeTown,
                   String homeCountry, String nationality, String email, String[] interests) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.homeTown = homeTown;
        this.homeCountry = homeCountry;
        this.nationality = nationality;
        this.email = email;
        this.interests = interests;
        this.friends = new ArrayList<>();
    }

    /**
     * Gets the home town
     *
     * @return the home town
     */
    public String getHomeTown() {
        return homeTown;
    }

    /**
     * Sets the home town
     *
     * @param homeTown new home town
     */
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    /**
     * Gets the home country
     *
     * @return the home country
     */
    public String getHomeCountry() {
        return homeCountry;
    }

    /**
     * Sets the home country
     *
     * @param homeCountry new home country
     */
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    /**
     * Gets the nationality
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality
     *
     * @param nationality new nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Get the interests
     *
     * @return the interests
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * Sets the interests
     *
     * @param interests new interests
     */
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     * Get full date of birth comprised of birthDay, birthMonth and birthYear
     *
     * @return the formatted birthday
     */
    public String getDateOfBirth() {
        return String.format("%d/%d/%d", birthDay, birthMonth, birthYear);
    }

    /**
     * Get the full name comprised of firstName and lastName
     *
     * @return the formatted full name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Gets the email
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     *
     * @param email new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds a friend to the profile
     *
     * @param p reference to the profile object to be added as a friend
     */
    public void addFriend(Profile p) {
        friends.add(p);
    }

    /**
     * Get the friend at the specified index
     *
     * @param i index
     * @return the profile object found at the index in the friends array list
     */
    public Profile getFriend(int i) {
        return friends.get(i);
    }

    /**
     * Get the number of friends the profile has
     *
     * @return integer of the number of friends
     */
    public int numOfFriends() {
        return friends.size();
    }

    /**
     * Generates a formmated string showing all the stored information about the profile
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        String info = String.format("Name: %s\nD.O.B: %s\nFrom: %s, %s\nNationality: %s\nEmail: %s\n",
                getName(), getDateOfBirth(), homeTown, homeCountry, nationality, email);

        StringBuilder interests = new StringBuilder();
        interests.append("Interests: ");
        if (this.interests.length != 0) {
            for (String interest : this.interests) {
                interests.append(interest + ", ");
            }
        } else {
            interests.append("(No Interests");
        }

        StringBuilder friends = new StringBuilder();
        friends.append("Friends: ");
        if (!this.friends.isEmpty()) {
            for (Profile friend : this.friends) {
                friends.append(friend.getName() + ", ");
            }
        } else {
            friends.append("(No Friends)");
        }

        return info + interests + "\n" + friends + "\n";
    }
}
