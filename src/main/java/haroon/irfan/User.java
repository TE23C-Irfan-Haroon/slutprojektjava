package haroon.irfan;

/**
 * Haroon Irfan
 * Klassen User representerar en kund/användare i bibliotekssystemet.
 */
public class User implements Comparable<User> {

    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(User otherUser) {
        return this.name.compareToIgnoreCase(otherUser.name);
    }
}
