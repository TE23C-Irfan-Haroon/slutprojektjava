package haroon.irfan.manager;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import haroon.irfan.model.*;
import haroon.irfan.service.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import haroon.irfan.service.ApiService;

/**
 * Haroon Irfan
 * Klassen LoanManager hanterar utlåning och återlämning av objekt.
 */
public class LoanManager implements FileStorage {


    /**
     * Lånar en bok om den är tillgänglig.
     *
     * @param userId användarens id
     * @param bookId bokens id
     * @param books  lista med böcker
     * @param loans  lista med aktiva lån
     */
    public static void borrowBook(String userId, String bookId, ArrayList<Book> books, ArrayList<Loan> loans) {

        for (Book book : books) {
            if (book.getId().equals(bookId)) {

                if (book.getIsAvailable()) {
                    book.setAvailable(false);
                    ApiService.updateBookOnServer(book);
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

    
    /**
     * Lämnar tillbaka en bok och tar bort lånet.
     *
     * @param bookId bokens id
     * @param books  lista med böcker
     * @param loans  lista med aktiva lån
     */
    public static void returnBook(String bookId, ArrayList<Book> books, ArrayList<Loan> loans) {

        for (Book book : books) {
            if (book.getId().equals(bookId)) {

                book.setAvailable(true);
                ApiService.updateBookOnServer(book);
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
                    ApiService.updateMagazineOnServer(magazine);
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
                ApiService.updateMagazineOnServer(magazine);
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
                    ApiService.updateMediaOnServer(media);
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
                ApiService.updateMediaOnServer(media);
                loans.removeIf(loan -> loan.getItemId().equals(mediaId) && loan.getItemType().equals("media"));

                System.out.println("Media har lämnats tillbaka.");

                return;
            }
        }

        System.out.println("Media hittades inte.");
    }

   
    /**
     * Sparar alla lån till en JSON-fil.
     *
     * @param loans lista med lån
     */
    public static void saveLoansToFile(ArrayList<Loan> loans) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(loans);

            Files.writeString(Paths.get("loans.json"), json);

            System.out.println("Lån har sparats till fil.");

        } catch (Exception e) {
            System.out.println("Fel vid sparande av lån.");
        }
    }

    
    /**
     * Läser in lån från JSON-fil när programmet startar.
     *
     * @return lista med lån
     */
    public static ArrayList<Loan> loadLoansFromFile() {
        try {
            Gson gson = new Gson();

            String json = Files.readString(Paths.get("loans.json"));

            Loan[] loanArray = gson.fromJson(json, Loan[].class);

            return new ArrayList<>(java.util.Arrays.asList(loanArray));

        } catch (Exception e) {
            System.out.println("Ingen lånefil hittades. Startar med tom lånelista.");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveLoans(ArrayList<Loan> loans) {
        saveLoansToFile(loans);
    }

    @Override
    public ArrayList<Loan> loadLoans() {
        return loadLoansFromFile();
    }
}