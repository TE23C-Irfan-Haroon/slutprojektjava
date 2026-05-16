package haroon.irfan;

/**
 * Haroon Irfan
 * Klassen Movie representerar en film i bibliotekssystemet.
 */
public class Movie extends Media {

    private String genre;
    private int minutes;

    public Movie(String id, String type, String title, String genre, int minutes, boolean isAvailable) {
        super(id, type, title, isAvailable);
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