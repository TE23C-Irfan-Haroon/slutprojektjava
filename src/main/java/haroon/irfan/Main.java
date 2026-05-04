package haroon.irfan;
import java.util.ArrayList;
import java.util.Scanner;

import haroon.Book;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Magazine> magazines = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Hämta böcker");
            System.out.println("2. Hämta tidningar");
            System.out.println("3. Visa böcker");
            System.ou
            t.println("4. Visa tidningar");
            System.out.println("5. Lägg till bok");
            System.out.println("6. Lägg till tidning");
            System.out.println("7. Avsluta");
            System.out.print("Välj ett alternativ: ");
           
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    
                    break;
            
                case 2:

                    break;
                case 3:
                    System.out.println("\n--- Böcker ---");
                    for (Book book : books) {
                        System.out.println(book.getTitle() + " - " + book.getAuthor());
                    }
                    break;
                case 4:
                    System.out.println("\n--- Magazines ---");
                    for (Magazine magazine : magazines) {
                        System.out.println(magazine.getTitle() + " - " + magazine.getCategory());
                    }
                    break;

                case 5: 
            }
        }
    }
}
