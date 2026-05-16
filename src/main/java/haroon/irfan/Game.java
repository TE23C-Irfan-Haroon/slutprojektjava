package haroon.irfan;

/**
 * Haroon Irfan
 * Klassen Game representerar ett spel i bibliotekssystemet.
 */
public class Game extends Media {

    private String genre;
    private int age;

    public Game(String id, String type, String title, String genre, int age, boolean isAvailable) {
        super(id, type, title, isAvailable);
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