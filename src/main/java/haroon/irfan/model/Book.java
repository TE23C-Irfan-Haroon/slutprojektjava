package haroon.irfan.model;

/**
 * Klassen Book representerar en bok i bibliotekssystemet.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class Book extends LibraryItem implements Comparable<Book> {

    private String author;
    private String genre;
    private int pages;

    public Book(String id, String title, boolean isAvailable, String author, String genre, int pages) {

        super(id, title, isAvailable);

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Författare får inte vara tom.");
        }

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre får inte vara tom.");
        }

        if (pages <= 0) {
            throw new IllegalArgumentException("Antal sidor måste vara större än 0.");
        }

        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    /**
     * Jämför böcker baserat på titel.
     *
     * @param otherBook boken som jämförs
     * @return resultatet av jämförelsen
     */
    @Override
    public int compareTo(Book otherBook) {
        return this.getTitle().compareToIgnoreCase(otherBook.getTitle());
    }
}
