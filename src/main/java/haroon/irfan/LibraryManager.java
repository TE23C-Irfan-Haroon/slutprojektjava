package haroon.irfan;

import java.util.ArrayList;

public class LibraryManager {

    public static Book findBookByTitle(ArrayList<Book> books, String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public static Magazine findMagazineByTitle(
            ArrayList<Magazine> magazines,
            String title) {

        for (Magazine magazine : magazines) {

            if (magazine.getTitle().equalsIgnoreCase(title)) {
                return magazine;
            }
        }

        return null;
    }

    public static User findUserByEmail(
            ArrayList<User> users,
            String email) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }

        return null;
    }
}