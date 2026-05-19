package haroon.irfan.model;

/**
 *
 * Klassen Movie representerar en film i bibliotekssystemet.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class Movie extends Media {

    private String genre;
    private int minutes;

    public Movie(String id, String type, String title, String genre, int minutes, boolean isAvailable) {
        
        super(id, type, title, isAvailable);

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre får inte vara tom.");
        }
    
        if (minutes <= 0) {
            throw new IllegalArgumentException("Minuter måste vara större än 0.");
        }

        this.genre = genre;
        this.minutes = minutes;
    }

    public String getGenre() {
        return genre;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String getInfo() {
        return "Film: " + getTitle() + " | Genre: " + genre + " | Minuter: " + minutes;
    }
}