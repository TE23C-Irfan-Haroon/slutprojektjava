package haroon.irfan.manager;

import java.util.Scanner;

import haroon.irfan.model.*;

/**
 * Haroon Irfan
 * Klassen InputManager hanterar användarinput och skapar objekt.
 */
public class InputManager {

    // Skapar ett nytt Book-objekt från användarinput.
    public static Book createBook(Scanner scanner) {
        String title;
        do {
            System.out.print("Titel: ");
            title = scanner.nextLine();

            if (title.isBlank()) {
                System.out.println("Titel får inte vara tom.");
            }
        } while (title.isBlank());

        String author;
        do {
            System.out.print("Författare: ");
            author = scanner.nextLine();

            if (author.isBlank()) {
                System.out.println("Författare får inte vara tom.");
            }
        } while (author.isBlank());

        String genre;
        do {
            System.out.print("Genre: ");
            genre = scanner.nextLine();

            if (genre.isBlank()) {
                System.out.println("Genre får inte vara tom.");
            }
        } while (genre.isBlank());

        int pages;
        do {
            System.out.print("Antal sidor: ");
            pages = readInt(scanner);

            if (pages <= 0) {
                System.out.println("Antal sidor måste vara större än 0.");
            }
        } while (pages <= 0);

        return new Book("local", title, true, author, genre, pages);
    }

    // Skapar ett nytt Magazine-objekt från användarinput.
    public static Magazine createMagazine(Scanner scanner) {

        String title;
        do {
            System.out.print("Titel: ");
            title = scanner.nextLine();

            if (title.isBlank()) {
                System.out.println("Titel får inte vara tom.");
            }

        } while (title.isBlank());

        String category;
        do {
            System.out.print("Kategori: ");
            category = scanner.nextLine();

            if (category.isBlank()) {
                System.out.println("Kategori får inte vara tom.");
            }

        } while (category.isBlank());

        int year;
        do {
            System.out.print("Publiceringsår: ");
            year = InputManager.readInt(scanner);

            if (year <= 0) {
                System.out.println(
                        "Publiceringsår måste vara större än 0.");
            }

        } while (year <= 0);

        int issueNumber;
        do {
            System.out.print("Nummer: ");
            issueNumber = InputManager.readInt(scanner);

            if (issueNumber <= 0) {
                System.out.println(
                        "Nummer måste vara större än 0.");
            }

        } while (issueNumber <= 0);

        return new Magazine("local", title, true, category, year, issueNumber);
    }

    // Skapar ett nytt User-objekt från användarinput.
    public static User createUser(Scanner scanner) {

        String name;
        do {
            System.out.print("Namn: ");
            name = scanner.nextLine();

            if (name.isBlank()) {
                System.out.println("Namn får inte vara tomt.");
            }

        } while (name.isBlank());

        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();

            if (email.isBlank()) {
                System.out.println("Email får inte vara tom.");
            }

        } while (email.isBlank());

        return new User("local", name, email);
    }

    // Skapar ett nytt SuspendedUser-objekt från användarinput.
    public static SuspendedUser createSuspendedUser(
            Scanner scanner) {

        String userId;

        do {
            System.out.print("User ID: ");
            userId = scanner.nextLine();

            if (userId.isBlank()) {
                System.out.println(
                        "User ID får inte vara tomt.");
            }

        } while (userId.isBlank());

        return new SuspendedUser("local", userId);
    }

    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Fel input. Skriv ett nummer: ");
            }
        }
    }
}