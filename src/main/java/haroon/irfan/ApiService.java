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

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

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

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            Magazine[] magazineArray = gson.fromJson(reader, Magazine[].class);

            return new ArrayList<>(Arrays.asList(magazineArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av tidningar.");
            return new ArrayList<>();
        }
    }

    public static ArrayList<User> fetchUsers() {
        try {
            URL url = new URL(BASE_URL + "/users");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            User[] userArray = gson.fromJson(reader, User[].class);

            return new ArrayList<>(Arrays.asList(userArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av användare.");
            return new ArrayList<>();
        }
    }

    public static ArrayList<SuspendedUser> fetchSuspendedUsers() {
        try {
            URL url = new URL(BASE_URL + "/suspendedUsers");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            SuspendedUser[] suspendedUserArray = gson.fromJson(reader, SuspendedUser[].class);

            return new ArrayList<>(Arrays.asList(suspendedUserArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av avstängda användare.");
            return new ArrayList<>();
        }
    }

    public static void addBookToServer(Book book) {
        try {
            URL url = new URL(BASE_URL + "/books");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(book);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 201) {
                System.out.println("Boken har lagts till på servern.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av bok på servern.");
        }
    }

    public static void addMagazineToServer(Magazine magazine) {
        try {
            URL url = new URL(BASE_URL + "/magazines");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(magazine);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 201) {
                System.out.println("Tidningen har lagts till på servern.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av tidning på servern.");
        }
    }

    public static void addUserToServer(User user) {
        try {
            URL url = new URL(BASE_URL + "/users");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(user);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 201) {
                System.out.println("Användaren har lagts till på servern.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av användare på servern.");
        }
    }

    public static void addSuspendedUserToServer(SuspendedUser suspendedUser) {
        try {
            URL url = new URL(BASE_URL + "/suspendedUsers");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(suspendedUser);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 201) {
                System.out.println("Användaren har blivit avstängd.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid avstängning av användare.");
        }
    }

    public static boolean deleteBookFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/books/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            System.out.println("Boken har tagits bort från servern.");
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av bok.");
            return false;
        }
    }

    public static boolean deleteMagazineFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/magazines/" + id);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            System.out.println("Magazine har tagits bort från servern.");
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av tidning.");
            return false;
        }
    }

    public static boolean deleteUserFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/users/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            System.out.println("User har tagits bort från servern.");
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av användare.");
            return false;
        }
    }

    public static boolean deleteSuspendedUserFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/suspendedUsers/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            System.out.println("Avstängningen har tagits bort från servern.");
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av avstängning.");
            return false;
        }
    }

}