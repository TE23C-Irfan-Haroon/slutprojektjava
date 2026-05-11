package haroon.irfan;

import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("4. Visa tidningar");
            System.out.println("5. Lägg till bok");
            System.out.println("6. Lägg till tidning");
            System.out.println("7. Avsluta");
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

                    System.out.println("Tidningen har lagts till.");
                    break;
                case 7:
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;

            }
        }
        scanner.close();
    }
}
