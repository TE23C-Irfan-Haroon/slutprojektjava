package haroon.irfan;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class ApiService {

    private static final String BASE_URL = "http://10.151.168.5:3108";

    public static ArrayList<Book> fetchBooks() {
        try {
            URL url = new URL(BASE_URL + "/books");

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader =
                    new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            Book[] bookArray = gson.fromJson(reader, Book[].class);

            return new ArrayList<>(Arrays.asList(bookArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av böcker.");
            return new ArrayList<>();
        }
    }

    public static ArrayList<Magazine> fetchMagazines() {
        try {
            URL url = new URL(BASE_URL + "/magazines");

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader =
                    new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            Magazine[] magazineArray = gson.fromJson(reader, Magazine[].class);

            return new ArrayList<>(Arrays.asList(magazineArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av tidningar.");
            return new ArrayList<>();
        }
    }
}