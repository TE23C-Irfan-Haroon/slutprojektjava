package haroon.irfan.manager;

import java.util.ArrayList;
import java.util.Collections;
import haroon.irfan.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * Klassen LibraryManager hanterar sökning,
 * sortering och kontroll av bibliotekets objekt.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */
public class LibraryManager {

    /**
     * Söker efter en bok via titel.
     *
     * @param books lista med böcker
     * @param title bokens titel
     * @return hittad bok eller null
     */
    public static Book findBookByTitle(ArrayList<Book> books, String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Söker efter en tidning med hjälp av titel.
    public static Magazine findMagazineByTitle(ArrayList<Magazine> magazines, String title) {

        for (Magazine magazine : magazines) {

            if (magazine.getTitle().equalsIgnoreCase(title)) {
                return magazine;
            }
        }

        return null;
    }

    /**
     * Söker efter användare via email med hjälp av HashMap.
     *
     * @param users lista med användare
     * @param email användarens email
     * @return hittad användare eller null
     */
    public static User findUserByEmail(ArrayList<User> users,
            String email) {

        Map<String, User> userMap = createUserEmailMap(users);

        return userMap.get(email);
    }

    // Sorterar böcker efter titel.
    public static void sortBooks(ArrayList<Book> books) {
        Collections.sort(books);
    }

    // Sorterar tidningar efter titel.
    public static void sortMagazines(ArrayList<Magazine> magazines) {
        Collections.sort(magazines);
    }

    // Sorterar användare efter namn.
    public static void sortUsers(ArrayList<User> users) {
        Collections.sort(users);
    }

    /**
     * Kontrollerar om en användare får låna böcker.
     *
     * @param userId         användarens id
     * @param suspendedUsers lista med avstängda användare
     * @return true om användaren får låna, annars false
     */
    public static boolean canUserBorrow(String userId, ArrayList<SuspendedUser> suspendedUsers) {
        for (SuspendedUser suspendedUser : suspendedUsers) {
            if (suspendedUser.getUserId().equals(userId)) {
                return false;
            }
        }

        return true;
    }

    // Skriver ut alla böcker i listan.
    public static void printBooks(ArrayList<Book> books) {

        for (Book book : books) {

            System.out.println(
                    "ID: " + book.getId() +
                            " | Titel: " + book.getTitle() +
                            " | Författare: " + book.getAuthor() +
                            " | Genre: " + book.getGenre() +
                            " | Sidor: " + book.getPages());
        }
    }

    // Skriver ut alla tidningar i listan.
    public static void printMagazines(ArrayList<Magazine> magazines) {

        for (Magazine magazine : magazines) {

            System.out.println(
                    "ID: " + magazine.getId() +
                            " | Titel: " + magazine.getTitle() +
                            " | Kategori: " + magazine.getCategory() +
                            " | År: " + magazine.getPublishedYear() +
                            " | Nummer: " + magazine.getIssueNumber());
        }
    }

    // Skriver ut alla media-objekt med polymorfism.
    public static void printMedia(ArrayList<Media> mediaList) {
        for (Media media : mediaList) {
            System.out.println(media.getInfo());
        }
    }

    // Skriver ut alla användare i listan.
    public static void printUsers(ArrayList<User> users) {

        for (User user : users) {

            System.out.println(
                    "ID: " + user.getId() +
                            " | Namn: " + user.getName() +
                            " | Email: " + user.getEmail());
        }
    }

    // Skriver ut alla avstängda användare i listan.
    public static void printSuspendedUsers(ArrayList<SuspendedUser> suspendedUsers) {

        for (SuspendedUser suspendedUser : suspendedUsers) {

            System.out.println(
                    "ID: " + suspendedUser.getId() +
                            " | UserID: " + suspendedUser.getUserId() +
                            " | Orsak: " + suspendedUser.getReason());
        }
    }

    // Söker efter och skriver ut en bok.
    public static void searchAndPrintBook(ArrayList<Book> books, String title) {

        Book foundBook = findBookByTitle(books, title);

        if (foundBook != null) {

            System.out.println(
                    "ID: " + foundBook.getId() +
                            " | Titel: " + foundBook.getTitle() +
                            " | Författare: " + foundBook.getAuthor() +
                            " | Genre: " + foundBook.getGenre() +
                            " | Sidor: " + foundBook.getPages());

        } else {
            System.out.println("Ingen bok hittades.");
        }
    }

    // Söker efter och skriver ut en tidning.
    public static void searchAndPrintMagazine(ArrayList<Magazine> magazines, String title) {

        Magazine foundMagazine = findMagazineByTitle(magazines, title);

        if (foundMagazine != null) {

            System.out.println(
                    "ID: " + foundMagazine.getId() +
                            " | Titel: " + foundMagazine.getTitle() +
                            " | Kategori: " + foundMagazine.getCategory() +
                            " | År: " + foundMagazine.getPublishedYear() +
                            " | Nummer: " + foundMagazine.getIssueNumber());

        } else {
            System.out.println("Ingen tidning hittades.");
        }
    }

    // Söker efter och skriver ut en användare.
    public static void searchAndPrintUser(ArrayList<User> users, String email) {

        User foundUser = findUserByEmail(users, email);

        if (foundUser != null) {

            System.out.println(
                    "ID: " + foundUser.getId() +
                            " | Namn: " + foundUser.getName() +
                            " | Email: " + foundUser.getEmail());

        } else {
            System.out.println("Ingen användare hittades.");
        }
    }

    /**
     * Skapar en HashMap där email används som nyckel.
     *
     * @param users lista med användare
     * @return map med email och User-objekt
     */
    public static Map<String, User> createUserEmailMap(ArrayList<User> users) {

        Map<String, User> userMap = new HashMap<>();

        for (User user : users) {
            userMap.put(user.getEmail(), user);
        }

        return userMap;
    }

    /**
     * Hämtar alla unika genrer från böckerna.
     *
     * @param books lista med böcker
     * @return set med unika genrer
     */
    public static Set<String> getUniqueBookGenres(ArrayList<Book> books) {

        Set<String> genres = new HashSet<>();

        for (Book book : books) {
            genres.add(book.getGenre());
        }

        return genres;
    }
}