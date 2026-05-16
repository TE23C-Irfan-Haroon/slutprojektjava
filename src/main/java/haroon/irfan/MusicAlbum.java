package haroon.irfan;

/**
 * Haroon Irfan
 * Klassen MusicAlbum representerar ett musikalbum i bibliotekssystemet.
 */
public class MusicAlbum extends Media {

    private String artist;

    public MusicAlbum(String id, String type, String title, String artist, boolean isAvailable) {
        super(id, type, title, isAvailable);
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