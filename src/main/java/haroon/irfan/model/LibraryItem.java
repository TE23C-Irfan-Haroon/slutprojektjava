package haroon.irfan.model;

/**
 * 
 * Klassen LibraryItem är basklassen för saker som biblioteket kan låna ut.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */

public class LibraryItem {
    private String id;
    private String title;
    private boolean isAvailable;

    public LibraryItem(String id, String title, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
