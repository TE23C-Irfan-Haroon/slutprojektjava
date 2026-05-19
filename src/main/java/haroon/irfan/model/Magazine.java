package haroon.irfan.model;

/**
 * 
 * Klassen Magazine representerar en tidning i bibliotekssystemet.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class Magazine extends LibraryItem implements Comparable<Magazine> {
    private String category;
    private int publishedYear;
    private int issueNumber;

    public Magazine(String id, String title, boolean isAvailable, String category, int publishedYear, int issueNumber) {

        super(id, title, isAvailable);

        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Kategori får inte vara tom.");
        }

        if (publishedYear <= 0) {
            throw new IllegalArgumentException("Publiceringsår måste vara större än 0.");
        }

        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Nummer måste vara större än 0.");
        }

        this.category = category;
        this.publishedYear = publishedYear;
        this.issueNumber = issueNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    /**
     * Jämför tidningar baserat på titel.
     *
     * @param otherMagazine tidningen som jämförs
     * @return resultatet av jämförelsen
     */
    @Override
    public int compareTo(Magazine otherMagazine) {
        return this.getTitle().compareToIgnoreCase(otherMagazine.getTitle());
    }
}
