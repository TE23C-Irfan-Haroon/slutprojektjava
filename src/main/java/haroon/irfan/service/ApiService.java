package haroon.irfan.service;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import haroon.irfan.model.Book;
import haroon.irfan.model.Game;
import haroon.irfan.model.Magazine;
import haroon.irfan.model.Media;
import haroon.irfan.model.Movie;
import haroon.irfan.model.MusicAlbum;
import haroon.irfan.model.SuspendedUser;
import haroon.irfan.model.User;

/**
 * Klassen ApiService hanterar kommunikation med servern.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2025
 */
public class ApiService {

    private static final String BASE_URL = "http://10.151.168.5:3108";

    /**
     * Hämtar böcker från servern.
     *
     * @return lista med böcker
     */
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

    // Hämtar alla tidningar från servern och gör om JSON till Magazine-objekt.
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

    /**
     * Hämtar användare från servern.
     *
     * @return lista med användare
     */
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

    // Hämtar alla avstängda användare från servern.
    public static ArrayList<SuspendedUser> fetchSuspendedUsers() {
        try {
            URL url = new URL(BASE_URL + "/suspended");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();

            SuspendedUser[] suspendedUserArray = gson.fromJson(reader, SuspendedUser[].class);

            return new ArrayList<>(Arrays.asList(suspendedUserArray));

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av avstängda användare: " + e.getMessage());
            return new ArrayList<>();
        }

    }

    /**
     * Hämtar media från servern och skapar rätt objekt
     * beroende på vilken typ av media det är.
     *
     * @return lista med media-objekt
     */
    public static ArrayList<Media> fetchMedia() {
        ArrayList<Media> mediaList = new ArrayList<>();

        try {
            URL url = new URL(BASE_URL + "/media");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject object = element.getAsJsonObject();

                String id = object.get("id").getAsString();
                String type = object.get("type").getAsString();
                String title = object.get("title").getAsString();
                boolean isAvailable = object.get("isAvailable").getAsBoolean();

                if (type.equalsIgnoreCase("game")) {
                    String genre = object.get("genre").getAsString();
                    int age = object.get("age").getAsInt();

                    mediaList.add(new Game(id, type, title, genre, age, isAvailable));

                } else if (type.equalsIgnoreCase("movie")) {
                    String genre = object.get("genre").getAsString();
                    int minutes = object.get("minutes").getAsInt();

                    mediaList.add(new Movie(id, type, title, genre, minutes, isAvailable));

                } else if (type.equalsIgnoreCase("music_album")) {
                    String artist = object.get("artist").getAsString();

                    mediaList.add(new MusicAlbum(id, type, title, artist, isAvailable));
                }
            }

        } catch (Exception e) {
            System.out.println("Fel vid hämtning av media.");
        }

        return mediaList;
    }

    // Skickar en ny bok till servern med POST-request.
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

            if (responseCode == 201 || responseCode == 200 || responseCode == 500) {
                System.out.println("Boken har lagts till lokalt och på servern.");
            } else {
                System.out.println(
                        "Fel vid tillägg. Statuskod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av bok på servern.");
        }
    }

    // Skickar en ny tidning till servern med POST-request.
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

            if (responseCode == 201 || responseCode == 200 || responseCode == 500) {
                System.out.println("Tidningen har lagts till lokalt och på servern.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av tidning på servern.");
        }
    }

    // Skickar en ny användare till servern med POST-request.
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

            if (responseCode == 201 || responseCode == 200 || responseCode == 500) {
                System.out.println("Användaren har lagts till lokalt och på servern.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid tillägg av användare på servern.");
        }
    }

    // Skickar en ny avstängning till servern med POST-request.
    public static void addSuspendedUserToServer(SuspendedUser suspendedUser) {
        try {
            URL url = new URL(BASE_URL + "/suspended");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(suspendedUser);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 201 || responseCode == 200 || responseCode == 500) {
                System.out.println("Användaren har blivit avstängd.");
            } else {
                System.out.println("Något gick fel. Serverkod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid avstängning av användare.");
        }
    }

    // Tar bort en bok från servern med DELETE-request.
    public static boolean deleteBookFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/books/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 204 || responseCode == 500) {
                System.out.println("Boken har tagits bort lokalt och på servern.");
            } else {
                System.out.println("Fel vid borttagning. Statuskod: " + responseCode);
            }
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av bok.");
            return false;
        }
    }

    // Tar bort en tidning från servern med DELETE-request.
    public static boolean deleteMagazineFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/magazines/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 204 || responseCode == 500) {
                System.out.println("Tidningen har tagits bort lokalt och på servern.");
            } else {
                System.out.println("Fel vid borttagning. Statuskod: " + responseCode);
            }
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av tidning.");
            return false;
        }
    }

    // Tar bort en användare från servern med DELETE-request.
    public static boolean deleteUserFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/users/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 204 || responseCode == 500) {
                System.out.println("Användaren har tagits bort lokalt och på servern.");
            } else {
                System.out.println("Fel vid borttagning. Statuskod: " + responseCode);
            }
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av användare.");
            return false;
        }
    }

    // Tar bort en avstängning från servern med DELETE-request.
    public static boolean deleteSuspendedUserFromServer(String id) {
        try {
            URL url = new URL(BASE_URL + "/suspended/" + id);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 204 || responseCode == 500) {
                System.out.println("Avstängningen har tagits bort lokalt och på servern.");
            } else {
                System.out.println("Fel vid borttagning. Statuskod: " + responseCode);
            }
            return true;

        } catch (Exception e) {
            System.out.println("Fel vid borttagning av avstängning.");
            return false;
        }
    }

    /**
     * Uppdaterar en bok på servern med PUT.
     *
     * @param book boken som ska uppdateras
     */
    public static void updateBookOnServer(Book book) {
        try {
            URL url = new URL(BASE_URL + "/books/" + book.getId());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(book);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 201 || responseCode == 500) {
                System.out.println("Boken har uppdaterats på servern.");
            } else {
                System.out.println("Fel vid uppdatering. Statuskod: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Fel vid uppdatering av bok på servern.");
        }
    }

    public static void updateMagazineOnServer(Magazine magazine) {
        try {
            URL url = new URL(BASE_URL + "/magazines/" + magazine.getId());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(magazine);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 201 || responseCode == 500) {
                System.out.println("Magazine har uppdaterats på servern.");
            } else {
                System.out.println("Fel vid uppdatering. Statuskod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid uppdatering av tidning på servern.");
        }
    }

    public static void updateMediaOnServer(Media media) {
        try {
            URL url = new URL(BASE_URL + "/media/" + media.getId());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(media);

            connection.getOutputStream().write(json.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == 200 || responseCode == 201 || responseCode == 500) {
                System.out.println("Media har uppdaterats på servern.");
            } else {
                System.out.println("Fel vid uppdatering. Statuskod: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Fel vid uppdatering av media på servern.");
        }
    }

}