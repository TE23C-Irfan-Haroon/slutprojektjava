/**
 * Haroon Irfan
 * Main-klassen styr programmets huvudmeny och programflöde.
 */

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
        ArrayList<Media> mediaList = new ArrayList<>();

        boolean running = true;

        while (running) {
            MenuManager.showMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    MenuManager.showFetchMenu();
                    int fetchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (fetchChoice) {
                        case 1:
                            books = ApiService.fetchBooks();
                            System.out.println("Böcker har hämtats.");
                            break;

                        case 2:
                            magazines = ApiService.fetchMagazines();
                            System.out.println("Tidningar har hämtats.");
                            break;

                        case 3:
                            users = ApiService.fetchUsers();
                            System.out.println("Användare har hämtats.");
                            break;

                        case 4:
                            suspendedUsers = ApiService.fetchSuspendedUsers();
                            System.out.println("Avstängda användare har hämtats.");
                            break;

                        case 5:
                            mediaList = ApiService.fetchMedia();
                            System.out.println("Media har hämtats från servern.");
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }
                    break;
                case 2:

                    MenuManager.showDisplayMenu();
                    int displayChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (displayChoice) {

                        case 1:
                            LibraryManager.printBooks(books);
                            break;

                        case 2:
                            LibraryManager.printMagazines(magazines);
                            break;

                        case 3:
                            LibraryManager.printUsers(users);
                            break;

                        case 4:
                            LibraryManager.printSuspendedUsers(suspendedUsers);
                            break;

                        case 5:
                            LibraryManager.printMedia(mediaList);
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }

                    break;
                case 3:

                    MenuManager.showAddMenu();

                    int addChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (addChoice) {

                        case 1:
                            Book newBook = InputManager.createBook(scanner);
                            books.add(newBook);
                            ApiService.addBookToServer(newBook);
                            System.out.println("Boken har lagts till lokalt och på servern.");
                            break;

                        case 2:
                            Magazine newMagazine = InputManager.createMagazine(scanner);
                            magazines.add(newMagazine);
                            ApiService.addMagazineToServer(newMagazine);
                            System.out.println("Tidningen har lagts till lokalt och på servern.");
                            break;

                        case 3:
                            User newUser = InputManager.createUser(scanner);
                            users.add(newUser);
                            ApiService.addUserToServer(newUser);
                            System.out.println("Användaren har lagts till lokalt och på servern.");
                            break;

                        case 4:
                            SuspendedUser suspendedUser = InputManager.createSuspendedUser(scanner);
                            suspendedUsers.add(suspendedUser);
                            ApiService.addSuspendedUserToServer(suspendedUser);
                            System.out.println("Användaren har blivit avstängd.");
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }

                    break;
                case 4:

                    MenuManager.showDeleteMenu();

                    int deleteChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (deleteChoice) {

                        case 1:
                            System.out.print("Ange bok-id: ");
                            String bookId = scanner.nextLine();

                            if (ApiService.deleteBookFromServer(bookId)) {
                                books.removeIf(book -> book.getId().equals(bookId));
                                System.out.println("Boken har tagits bort lokalt och på servern.");
                            }
                            break;

                        case 2:
                            System.out.print("Ange tidnings-id: ");
                            String magazineId = scanner.nextLine();

                            if (ApiService.deleteMagazineFromServer(magazineId)) {
                                magazines.removeIf(magazine -> magazine.getId().equals(magazineId));
                                System.out.println("Tidningen har tagits bort lokalt och på servern.");
                            }
                            break;

                        case 3:
                            System.out.print("Ange användar-id: ");
                            String userId = scanner.nextLine();

                            if (ApiService.deleteUserFromServer(userId)) {
                                users.removeIf(user -> user.getId().equals(userId));
                                System.out.println("Användaren har tagits bort lokalt och på servern.");
                            }
                            break;

                        case 4:
                            System.out.print("Ange avstängnings-id: ");
                            String suspendedId = scanner.nextLine();

                            if (ApiService.deleteSuspendedUserFromServer(suspendedId)) {
                                suspendedUsers.removeIf(suspendedUser -> suspendedUser.getId().equals(suspendedId));
                                System.out.println("Avstängningen har tagits bort lokalt och på servern.");
                            }
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }

                    break;
                case 5:

                    MenuManager.showSearchMenu();

                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {

                        case 1:

                            System.out.print("Ange titel på boken: ");
                            String bookTitle = scanner.nextLine();

                            LibraryManager.searchAndPrintBook(books, bookTitle);

                            break;

                        case 2:

                            System.out.print("Ange titel på tidningen: ");
                            String magazineTitle = scanner.nextLine();

                            LibraryManager.searchAndPrintMagazine(magazines, magazineTitle);

                            break;

                        case 3:

                            System.out.print("Ange email: ");
                            String email = scanner.nextLine();

                            LibraryManager.searchAndPrintUser(users, email);

                            break;
                        case 4:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }

                    break;
                case 6:

                    MenuManager.showSortMenu();

                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (sortChoice) {

                        case 1:
                            LibraryManager.sortBooks(books);
                            LibraryManager.printBooks(books);
                            System.out.println("Böcker sorterade efter titel.");
                            break;

                        case 2:
                            LibraryManager.sortMagazines(magazines);
                            LibraryManager.printMagazines(magazines);
                            System.out.println("Tidningar sorterade efter titel.");
                            break;

                        case 3:
                            LibraryManager.sortUsers(users);
                            LibraryManager.printUsers(users);
                            System.out.println("Användare sorterade efter namn.");
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }

                    break;
                case 7:

                    System.out.print("Ange användar-id: ");
                    String borrowUserId = scanner.nextLine();

                    boolean canBorrow = LibraryManager.canUserBorrow(
                            borrowUserId,
                            suspendedUsers);

                    if (canBorrow) {
                        System.out.println("Användaren får låna.");
                    } else {
                        System.out.println("Användaren får inte låna.");
                    }

                    break;

                case 8:
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;
            }
        }
        scanner.close();
    }
}
