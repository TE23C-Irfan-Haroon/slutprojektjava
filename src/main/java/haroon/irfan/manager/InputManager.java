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
        System.out.print("Titel: ");
        String title = scanner.nextLine();

        System.out.print("Författare: ");
        String author = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Antal sidor: ");
        int pages = scanner.nextInt();
        scanner.nextLine();

        return new Book("local", title, true, author, genre, pages);
    }

    // Skapar ett nytt Magazine-objekt från användarinput.
    public static Magazine createMagazine(Scanner scanner) {
        System.out.print("Titel: ");
        String title = scanner.nextLine();

        System.out.print("Kategori: ");
        String category = scanner.nextLine();

        System.out.print("Publiceringsår: ");
        int year = InputManager.readInt(scanner);

        System.out.print("Nummer: ");
        int issueNumber = InputManager.readInt(scanner);
        scanner.nextLine();

        return new Magazine("local", title, true, category, year, issueNumber);
    }

    // Skapar ett nytt User-objekt från användarinput.
    public static User createUser(Scanner scanner) {
        System.out.print("Namn: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new User("local", name, email);
    }

    // Skapar ett nytt SuspendedUser-objekt från användarinput.
    public static SuspendedUser createSuspendedUser(Scanner scanner) {
        System.out.print("User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Orsak: ");
        String reason = scanner.nextLine();

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