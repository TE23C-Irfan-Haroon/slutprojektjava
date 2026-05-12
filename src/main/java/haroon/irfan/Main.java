package haroon.irfan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Magazine> magazines = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<SuspendedUser> suspendedUsers = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Hämta böcker");
            System.out.println("2. Hämta tidningar");
            System.out.println("3. Visa böcker");
            System.out.println("4. Visa tidningar");
            System.out.println("5. Lägg till bok");
            System.out.println("6. Lägg till tidning");
            System.out.println("7. Hämta användare");
            System.out.println("8. Hämta avstängda användare");
            System.out.println("9. lägg till användare");
            System.out.println("10. Stäng av användare");
            System.out.println("11. Ta bort bok");
            System.out.println("12. Ta bort tidning");
            System.out.println("13. Ta bort användare");
            System.out.println("14. Ta bort avstängning");
            System.out.println("15. Avsluta");
            System.out.print("Välj ett alternativ: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    books = ApiService.fetchBooks();
                    System.out.println("Böckerna har hämtats från servern.");

                    break;
                case 2:
                    magazines = ApiService.fetchMagazines();
                    System.out.println("Tidningar har hämtats från servern.");
                    break;
                case 3:
                    System.out.println("\n--- Böcker ---");
                    for (Book book : books) {
                        System.out.println(
                                "ID: " + book.getId() +
                                        " | Titel: " + book.getTitle() +
                                        " | Författare: " + book.getAuthor() +
                                        " | Genre: " + book.getGenre() +
                                        " | Sidor: " + book.getPages());
                    }
                    break;
                case 4:
                    System.out.println("\n--- Magazines ---");
                    for (Magazine magazine : magazines) {
                        System.out.println(magazine.getTitle() + " - " + magazine.getCategory());
                    }
                    break;

                case 5:
                    System.out.print("Titel: ");
                    String bookTitle = scanner.nextLine();

                    System.out.print("Författare: ");
                    String author = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Antal sidor: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book("local", bookTitle, true, author, genre, pages);
                    books.add(newBook);
                    ApiService.addBookToServer(newBook);

                    System.out.println("Boken har lagts till.");
                    break;
                case 6:
                    System.out.print("Titel: ");
                    String magazineTitle = scanner.nextLine();

                    System.out.print("Kategori: ");
                    String category = scanner.nextLine();

                    System.out.print("Publiceringsår: ");
                    int year = scanner.nextInt();

                    System.out.print("Nummer: ");
                    int issueNumber = scanner.nextInt();
                    scanner.nextLine();

                    Magazine newMagazine = new Magazine("local", magazineTitle, true, category, year, issueNumber);
                    magazines.add(newMagazine);
                    ApiService.addMagazineToServer(newMagazine);

                    System.out.println("Tidningen har lagts till.");
                    break;
                case 7:
                    users = ApiService.fetchUsers();
                    System.out.println("Användare har hämtats från servern.");
                    break;
                case 8:
                    suspendedUsers = ApiService.fetchSuspendedUsers();
                    System.out.println("Avstängda användare har hämtats från servern.");
                    break;
                case 9:
                    System.out.print("Namn: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    User newUser = new User("local", name, email);

                    users.add(newUser);
                    ApiService.addUserToServer(newUser);

                    System.out.println("Användaren har lagts till.");
                    break;
                case 10:
                    System.out.print("User ID: ");
                    String userId = scanner.nextLine();

                    System.out.print("Orsak: ");
                    String reason = scanner.nextLine();

                    SuspendedUser suspendedUser = new SuspendedUser("local", userId, reason);

                    suspendedUsers.add(suspendedUser);

                    ApiService.addSuspendedUserToServer(suspendedUser);

                    System.out.println("Användaren har blivit avstängd.");
                    break;
                case 11:
                    System.out.print("Ange id på boken som ska tas bort: ");
                    String bookId = scanner.nextLine();

                    boolean deletedBook = ApiService.deleteBookFromServer(bookId);

                    if (deletedBook) {
                        books.removeIf(book -> book.getId().equals(bookId));
                    }

                    break;
                case 12:

                    System.out.print("Ange tidnings-id: ");
                    String deleteMagazineId = scanner.nextLine();

                    boolean deletedMagazine = ApiService.deleteMagazineFromServer(deleteMagazineId);

                    if (deletedMagazine) {
                        magazines.removeIf(magazine -> magazine.getId().equals(deleteMagazineId));
                    }

                    break;
                case 13:

                    System.out.print("Ange användar-id: ");
                    String deleteUserId = scanner.nextLine();

                    boolean deletedUser = ApiService.deleteUserFromServer(deleteUserId);

                    if (deletedUser) {
                        users.removeIf(user -> user.getId().equals(deleteUserId));
                    }

                    break;
                case 14:

                    System.out.print("Ange avstängnings-id: ");
                    String deleteSuspendedId = scanner.nextLine();

                    boolean deletedSuspended = ApiService.deleteSuspendedUserFromServer(deleteSuspendedId);

                    if (deletedSuspended) {
                        suspendedUsers.removeIf(user -> user.getId().equals(deleteSuspendedId));
                    }

                    break;
                case 15:
                    System.out.print("Ange titel på boken: ");
                    String searchBookTitle = scanner.nextLine();

                    Book foundBook = LibraryManager.findBookByTitle(books, searchBookTitle);
                    if (foundBook != null) {
                        System.out.println("Bok hittad:");
                        System.out.println("ID: " + foundBook.getId());
                        System.out.println("Titel: " + foundBook.getTitle());
                        System.out.println("Författare: " + foundBook.getAuthor());
                        System.out.println("Genre: " + foundBook.getGenre());
                        System.out.println("Sidor: " + foundBook.getPages());
                    } else {
                        System.out.println("Ingen bok hittades med den titeln.");
                    }
                    break;
                case 16:
                    System.out.print("Ange titel på tidningen: ");
                    String searchMagazineTitle = scanner.nextLine();

                    Magazine foundMagazine = LibraryManager.findMagazineByTitle(magazines, searchMagazineTitle);

                    if (foundMagazine != null) {
                        System.out.println("Tidning hittad:");
                        System.out.println("ID: " + foundMagazine.getId());
                        System.out.println("Titel: " + foundMagazine.getTitle());
                        System.out.println("Kategori: " + foundMagazine.getCategory());
                        System.out.println("Publiceringsår: " + foundMagazine.getPublishedYear());
                        System.out.println("Nummer: " + foundMagazine.getIssueNumber());
                    } else {
                        System.out.println("Ingen tidning hittades med den titeln.");
                    }
                    break;
                case 17:
                    System.out.print("Ange email: ");
                    String searchEmail = scanner.nextLine();

                    User foundUser = LibraryManager.findUserByEmail(users, searchEmail);

                    if (foundUser != null) {
                        System.out.println("Användare hittad:");
                        System.out.println("ID: " + foundUser.getId());
                        System.out.println("Namn: " + foundUser.getName());
                        System.out.println("Email: " + foundUser.getEmail());
                    } else {
                        System.out.println("Ingen användare hittades med den emailen.");
                    }
                    break;
                case 18:
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;

            }
        }
        scanner.close();
    }
}
