package haroon.irfan.model;

/**
 * 
 * Klassen MusicAlbum representerar ett musikalbum i bibliotekssystemet.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class MusicAlbum extends Media {

    private String artist;

    public MusicAlbum(String id, String type, String title, String artist, boolean isAvailable) {
        
        super(id, type, title, isAvailable);

        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Artist får inte vara tom.");
        }

        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String getInfo() {
        return "Musikalbum: " + getTitle() + " | Artist: " + artist;
    }
}