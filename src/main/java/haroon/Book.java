package haroon;

import haroon.irfan.LibraryItem;

public class Book extends LibraryItem {
    private String author;
    private String genre;
    private int pages;

    public Book(String id, String title, boolean isAvailable,
                String author, String genre, int pages) {

        super(id, title, isAvailable); // 🔥 this connects to LibraryItem

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
}

