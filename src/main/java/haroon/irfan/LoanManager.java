package haroon.irfan;

import java.util.ArrayList;

/**
 * Haroon Irfan
 * Klassen LoanManager hanterar utlåning och återlämning av objekt.
 */
public class LoanManager {

    // Lånar en bok om den är tillgänglig.
    public static void borrowBook(String userId, String bookId, ArrayList<Book> books, ArrayList<Loan> loans) {

        for (Book book : books) {
            if (book.getId().equals(bookId)) {

                if (book.getIsAvailable()) {
                    book.setAvailable(false);
                    loans.add(new Loan(userId, bookId, "book"));
                    System.out.println("Boken har lånats ut.");
                } else {
                    System.out.println("Boken är inte tillgänglig.");
                }

                return;
            }
        }

        System.out.println("Boken hittades inte.");
    }

    // Lämnar tillbaka en bok.
    public static void returnBook(String bookId, ArrayList<Book> books, ArrayList<Loan> loans) {

        for (Book book : books) {
            if (book.getId().equals(bookId)) {

                book.setAvailable(true);

                loans.removeIf(loan -> loan.getItemId().equals(bookId) && loan.getItemType().equals("book"));

                System.out.println("Boken har lämnats tillbaka.");
                return;
            }
        }

        System.out.println("Boken hittades inte.");
    }

    // Lånar en tidning om den är tillgänglig.
    public static void borrowMagazine(String userId, String magazineId, ArrayList<Magazine> magazines,
            ArrayList<Loan> loans) {

        for (Magazine magazine : magazines) {

            if (magazine.getId().equals(magazineId)) {

                if (magazine.getIsAvailable()) {

                    magazine.setAvailable(false);

                    loans.add(new Loan(userId, magazineId, "magazine"));

                    System.out.println("Tidningen har lånats ut.");

                } else {
                    System.out.println("Tidningen är inte tillgänglig.");
                }

                return;
            }
        }

        System.out.println("Tidningen hittades inte.");
    }

    // Lämnar tillbaka en tidning.
    public static void returnMagazine(String magazineId, ArrayList<Magazine> magazines, ArrayList<Loan> loans) {

        for (Magazine magazine : magazines) {

            if (magazine.getId().equals(magazineId)) {

                magazine.setAvailable(true);

                loans.removeIf(loan -> loan.getItemId().equals(magazineId) && loan.getItemType().equals("magazine"));

                System.out.println("Tidningen har lämnats tillbaka.");

                return;
            }
        }

        System.out.println("Tidningen hittades inte.");
    }

    // Lånar media om objektet är tillgängligt.
    public static void borrowMedia(String userId, String mediaId, ArrayList<Media> mediaList, ArrayList<Loan> loans) {

        for (Media media : mediaList) {

            if (media.getId().equals(mediaId)) {

                if (media.getIsAvailable()) {

                    media.setAvailable(false);

                    loans.add(new Loan(userId, mediaId, "media"));

                    System.out.println("Media har lånats ut.");

                } else {
                    System.out.println("Media är inte tillgänglig.");
                }

                return;
            }
        }

        System.out.println("Media hittades inte.");
    }

    // Lämnar tillbaka media.
    public static void returnMedia(String mediaId, ArrayList<Media> mediaList, ArrayList<Loan> loans) {

        for (Media media : mediaList) {

            if (media.getId().equals(mediaId)) {

                media.setAvailable(true);

                loans.removeIf(loan -> loan.getItemId().equals(mediaId) && loan.getItemType().equals("media"));

                System.out.println("Media har lämnats tillbaka.");

                return;
            }
        }

        System.out.println("Media hittades inte.");
    }
}