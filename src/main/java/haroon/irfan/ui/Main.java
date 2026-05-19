
package haroon.irfan.ui;

import java.util.ArrayList;
import java.util.Scanner;
import haroon.irfan.model.*;
import haroon.irfan.manager.*;
import haroon.irfan.service.*;

/**
 * Startklass för bibliotekssystemet.
 * Klassen hanterar programmets huvudloop och menyer.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2025
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibraryData data = new LibraryData();
        data.loans = LoanManager.loadLoansFromFile();

        boolean running = true;

        while (running) {
            MenuManager.showMainMenu();

            int choice = InputManager.readInt(scanner);

            switch (choice) {
                case 1:

                    MenuManager.showFetchMenu();
                    int fetchChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleFetchMenu(fetchChoice, data);

                    break;
                case 2:

                    MenuManager.showDisplayMenu();
                    int displayChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleDisplayMenu(displayChoice, data);
                    
                    break;
                case 3:

                    MenuManager.showAddMenu();
                    int addChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleAddMenu(addChoice, scanner, data);

                    break;
                case 4:

                    MenuManager.showDeleteMenu();
                    int deleteChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleDeleteMenu(deleteChoice, scanner, data);

                    break;
                case 5:

                    MenuManager.showSearchMenu();
                    int searchChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleSearchMenu(searchChoice, scanner, data);
                   
                    break;
                case 6:

                    MenuManager.showSortMenu();
                    int sortChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleSortMenu(sortChoice, data);

                    break;
                case 7:

                    System.out.print("Ange användar-id: ");
                    String borrowUserId = scanner.nextLine();

                    boolean canBorrow = LibraryManager.canUserBorrow(borrowUserId, data.suspendedUsers);

                    if (canBorrow) {
                        System.out.println("Användaren får låna.");
                    } else {
                        System.out.println("Användaren får inte låna.");
                    }

                    break;
                case 8:

                    MenuManager.showLoanMenu();
                    int loanChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleLoanMenu(loanChoice, scanner, data);

                    break;
                case 9:

                    MenuManager.showStreamMenu();
                    int streamChoice = InputManager.readInt(scanner);
                    SubMenuHandler.handleStreamMenu(streamChoice, scanner, data);
                    
                    break;
                case 10:
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;
            }
        }
        scanner.close();
    }
}
