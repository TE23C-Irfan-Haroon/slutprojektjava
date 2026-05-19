package haroon.irfan.model;

import java.util.ArrayList;

/**
 * 
 * Klassen LibraryData samlar programmets listor på ett ställe.
 * 
 * @author Haroon Irfan
 * @version 1.0
 * @since 2026
 */

public class LibraryData {

    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Magazine> magazines = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<SuspendedUser> suspendedUsers = new ArrayList<>();
    public ArrayList<Media> mediaList = new ArrayList<>();
    public ArrayList<Loan> loans = new ArrayList<>();
}