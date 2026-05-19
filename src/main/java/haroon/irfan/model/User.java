package haroon.irfan.model;

/**
 * 
 * Klassen User representerar en kund/användare i bibliotekssystemet.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class User implements Comparable<User> {

    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Namn får inte vara tomt.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email får inte vara tom.");
        }

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

    /**
     * Jämför användare baserat på namn.
     *
     * @param otherUser användaren som jämförs
     * @return resultatet av jämförelsen
     */
    @Override
    public int compareTo(User otherUser) {
        return this.name.compareToIgnoreCase(otherUser.name);
    }
}
