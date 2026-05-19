package haroon.irfan.manager;

import java.util.ArrayList;
import java.util.stream.Collectors;

import haroon.irfan.model.Book;

/**
 * Haroon Irfan
 * Klassen StreamManager hanterar filtrering, sortering, count och map med
 * streams.
 */
public class StreamManager {

    /**
     * Visar böcker som matchar en viss genre.
     *
     * @param books lista med böcker
     * @param genre vald genre
     */
    public static void printBooksByGenre(ArrayList<Book> books, String genre) {
        books.stream().filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getGenre()));
    }

    /**
     * Visar böcker av en viss författare.
     *
     * @param books  lista med böcker
     * @param author vald författare
     */
    public static void printBooksByAuthor(ArrayList<Book> books, String author) {
        books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));
    }

    
    /**
     * Sorterar och visar böcker efter författare.
     *
     * @param books lista med böcker
     */
    public static void printBooksSortedByAuthor(ArrayList<Book> books) {
        books.stream().sorted((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()))
                .forEach(book -> System.out.println(book.getAuthor() + " - " + book.getTitle()));
    }

    /**
     * Räknar hur många böcker en författare har skrivit.
     *
     * @param books  lista med böcker
     * @param author vald författare
     */
    public static void countBooksByAuthor(ArrayList<Book> books, String author) {
        long count = books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).count();

        System.out.println(author + " har skrivit " + count + " böcker.");
    }

   
    /**
     * Visar endast boktitlar med hjälp av map-stream.
     *
     * @param books lista med böcker
     */
    public static void printBookTitles(ArrayList<Book> books) {
        books.stream().map(Book::getTitle).forEach(System.out::println);
    }
}