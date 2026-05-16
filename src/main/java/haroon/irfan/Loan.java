package haroon.irfan;

/**
 * Haroon Irfan
 * Klassen Loan representerar en utlåning i bibliotekssystemet.
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