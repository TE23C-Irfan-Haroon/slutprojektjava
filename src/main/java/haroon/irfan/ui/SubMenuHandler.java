package haroon.irfan.ui;

import haroon.irfan.manager.InputManager;
import haroon.irfan.manager.LibraryManager;
import haroon.irfan.manager.LoanManager;
import haroon.irfan.manager.StreamManager;
import haroon.irfan.model.*;
import haroon.irfan.service.ApiService;

import java.util.ArrayList;
import java.util.Scanner;

public class SubMenuHandler {

    public static void handleFetchMenu(int fetchChoice, LibraryData data) {

        switch (fetchChoice) {
            case 1:
                data.books = ApiService.fetchBooks();
                System.out.println("Böcker har hämtats.");
                break;

            case 2:
                data.magazines = ApiService.fetchMagazines();
                System.out.println("Tidningar har hämtats.");
                break;

            case 3:
                data.users = ApiService.fetchUsers();
                System.out.println("Användare har hämtats.");
                break;

            case 4:
                data.suspendedUsers = ApiService.fetchSuspendedUsers();
                System.out.println("Avstängda användare har hämtats.");
                break;

            case 5:
                data.mediaList = ApiService.fetchMedia();
                System.out.println("Media har hämtats från servern.");
                break;

            case 6:
                break;

            default:
                System.out.println("Fel val.");
        }
    }

    public static void handleDisplayMenu(int displayChoice, LibraryData data) {

        switch (displayChoice) {

            case 1:
                LibraryManager.printBooks(data.books);
                break;

            case 2:
                LibraryManager.printMagazines(data.magazines);
                break;

            case 3:
                LibraryManager.printUsers(data.users);
                break;

            case 4:
                LibraryManager.printSuspendedUsers(data.suspendedUsers);
                break;

            case 5:
                LibraryManager.printMedia(data.mediaList);
                break;

            case 6:
                break;

            default:
                System.out.println("Fel val.");
        }

    }

    public static void handleAddMenu(int addChoice, Scanner scanner, LibraryData data) {

        switch (addChoice) {

            case 1:
                Book newBook = InputManager.createBook(scanner);
                data.books.add(newBook);
                ApiService.addBookToServer(newBook);
                System.out.println("Boken har lagts till lokalt och på servern.");
                break;

            case 2:
                Magazine newMagazine = InputManager.createMagazine(scanner);
                data.magazines.add(newMagazine);
                ApiService.addMagazineToServer(newMagazine);
                System.out.println("Tidningen har lagts till lokalt och på servern.");
                break;

            case 3:
                User newUser = InputManager.createUser(scanner);
                data.users.add(newUser);
                ApiService.addUserToServer(newUser);
                System.out.println("Användaren har lagts till lokalt och på servern.");
                break;

            case 4:
                SuspendedUser suspendedUser = InputManager.createSuspendedUser(scanner);
                data.suspendedUsers.add(suspendedUser);
                ApiService.addSuspendedUserToServer(suspendedUser);
                System.out.println("Användaren har blivit avstängd.");
                break;

            case 5:
                break;

            default:
                System.out.println("Fel val.");
        }
    }

    public static void handleDeleteMenu(int deleteChoice, Scanner scanner, LibraryData data) {
        switch (deleteChoice) {

            case 1:
                System.out.print("Ange bok-id: ");
                String bookId = scanner.nextLine();

                if (ApiService.deleteBookFromServer(bookId)) {
                    data.books.removeIf(book -> book.getId().equals(bookId));
                    System.out.println("Boken har tagits bort lokalt och på servern.");
                }
                break;

            case 2:
                System.out.print("Ange tidnings-id: ");
                String magazineId = scanner.nextLine();

                if (ApiService.deleteMagazineFromServer(magazineId)) {
                    data.magazines.removeIf(magazine -> magazine.getId().equals(magazineId));
                    System.out.println("Tidningen har tagits bort lokalt och på servern.");
                }
                break;

            case 3:
                System.out.print("Ange användar-id: ");
                String userId = scanner.nextLine();

                if (ApiService.deleteUserFromServer(userId)) {
                    data.users.removeIf(user -> user.getId().equals(userId));
                    System.out.println("Användaren har tagits bort lokalt och på servern.");
                }
                break;

            case 4:
                System.out.print("Ange avstängnings-id: ");
                String suspendedId = scanner.nextLine();

                if (ApiService.deleteSuspendedUserFromServer(suspendedId)) {
                    data.suspendedUsers.removeIf(suspendedUser -> suspendedUser.getId().equals(suspendedId));
                    System.out.println("Avstängningen har tagits bort lokalt och på servern.");
                }
                break;

            case 5:
                break;

            default:
                System.out.println("Fel val.");
        }

    }

    public static void handleSearchMenu(int searchChoice, Scanner scanner, LibraryData data) {
        switch (searchChoice) {

            case 1:

                System.out.print("Ange titel på boken: ");
                String bookTitle = scanner.nextLine();

                LibraryManager.searchAndPrintBook(data.books, bookTitle);

                break;

            case 2:

                System.out.print("Ange titel på tidningen: ");
                String magazineTitle = scanner.nextLine();

                LibraryManager.searchAndPrintMagazine(data.magazines, magazineTitle);

                break;

            case 3:

                System.out.print("Ange email: ");
                String email = scanner.nextLine();

                LibraryManager.searchAndPrintUser(data.users, email);

                break;
            case 4:
                break;

            default:
                System.out.println("Fel val.");
        }

    }

    public static void handleSortMenu(int sortChoice, LibraryData data) {

        switch (sortChoice) {

            case 1:
                LibraryManager.sortBooks(data.books);
                LibraryManager.printBooks(data.books);
                System.out.println("Böcker sorterade efter titel.");
                break;

            case 2:
                LibraryManager.sortMagazines(data.magazines);
                LibraryManager.printMagazines(data.magazines);
                System.out.println("Tidningar sorterade efter titel.");
                break;

            case 3:
                LibraryManager.sortUsers(data.users);
                LibraryManager.printUsers(data.users);
                System.out.println("Användare sorterade efter namn.");
                break;

            case 4:
                break;

            default:
                System.out.println("Fel val.");
        }
    }

    public static void handleLoanMenu(int loanChoice, Scanner scanner, LibraryData data) {
        switch (loanChoice) {

            case 1:
                System.out.print("Ange användar-id: ");
                String bookUserId = scanner.nextLine();

                System.out.print("Ange bok-id: ");
                String bookId = scanner.nextLine();

                LoanManager.borrowBook(bookUserId, bookId, data.books, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 2:
                System.out.print("Ange användar-id: ");
                String magazineUserId = scanner.nextLine();

                System.out.print("Ange tidnings-id: ");
                String magazineId = scanner.nextLine();

                LoanManager.borrowMagazine(magazineUserId, magazineId, data.magazines, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 3:
                System.out.print("Ange användar-id: ");
                String mediaUserId = scanner.nextLine();

                System.out.print("Ange media-id: ");
                String mediaId = scanner.nextLine();

                LoanManager.borrowMedia(mediaUserId, mediaId, data.mediaList, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 4:
                System.out.print("Ange bok-id: ");
                String returnBookId = scanner.nextLine();

                LoanManager.returnBook(returnBookId, data.books, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 5:
                System.out.print("Ange tidnings-id: ");
                String returnMagazineId = scanner.nextLine();

                LoanManager.returnMagazine(returnMagazineId, data.magazines, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 6:
                System.out.print("Ange media-id: ");
                String returnMediaId = scanner.nextLine();

                LoanManager.returnMedia(returnMediaId, data.mediaList, data.loans);
                LoanManager.saveLoansToFile(data.loans);
                break;

            case 7:
                break;

            default:
                System.out.println("Fel val.");
        }

    }

    public static void handleStreamMenu(int streamChoice, Scanner scanner, LibraryData data) {
        switch (streamChoice) {

                        case 1:

                            System.out.print("Ange genre: ");
                            String genre = scanner.nextLine();

                            StreamManager.printBooksByGenre(data.books, genre);

                            break;

                        case 2:

                            System.out.print("Ange författare: ");
                            String author = scanner.nextLine();

                            StreamManager.printBooksByAuthor(data.books, author);

                            break;

                        case 3:

                            StreamManager.printBooksSortedByAuthor(data.books);

                            break;

                        case 4:

                            System.out.print("Ange författare: ");
                            String countAuthor = scanner.nextLine();

                            StreamManager.countBooksByAuthor(data.books, countAuthor);

                            break;

                        case 5:

                            StreamManager.printBookTitles(data.books);

                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("Fel val.");
                    }
    }
}
