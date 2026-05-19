package haroon.irfan.model;

/**
 * 
 * Klassen SuspendedUser representerar en avstängd användare.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class SuspendedUser {

    private String id;
    private String customer_id;
    private String reason;

    public SuspendedUser(String id, String customer_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.reason = "Ingen orsak angiven";
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return customer_id;
    }

    public String getReason() {
        return "Ingen orsak angiven";
    }
}