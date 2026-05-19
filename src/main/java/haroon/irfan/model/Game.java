package haroon.irfan.model;


/**
 * Klassen Game representerar ett spel i bibliotekssystemet.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class Game extends Media {

    private String genre;
    private int age;

    public Game(String id, String type, String title, String genre, int age, boolean isAvailable) {
        
        super(id, type, title, isAvailable);

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre får inte vara tom.");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Ålder får inte vara negativ.");
        }

        this.genre = genre;
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getInfo() {
        return "Spel: " + getTitle() + " | Genre: " + genre + " | Ålder: " + age;
    }
}