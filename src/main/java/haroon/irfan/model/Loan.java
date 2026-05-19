package haroon.irfan.model;

/**
 * 
 * Klassen Loan representerar en utlåning i bibliotekssystemet.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class Loan {

    private String userId;
    private String itemId;
    private String itemType;

    public Loan(String userId, String itemId, String itemType) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemType = itemType;
    }

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemType() {
        return itemType;
    }
}