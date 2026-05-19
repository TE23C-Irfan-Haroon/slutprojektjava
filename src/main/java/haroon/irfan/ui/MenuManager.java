package haroon.irfan.ui;

/**
 * Haroon Irfan
 * Klassen MenuManager visar programmets menyer och undermenyer.
 */
public class MenuManager {

    // Visar huvudmenyn.
    public static void showMainMenu() {

        System.out.println("\n===== Library System =====");
        System.out.println("1. Hämta data");
        System.out.println("2. Visa data");
        System.out.println("3. Lägg till");
        System.out.println("4. Ta bort");
        System.out.println("5. Sök");
        System.out.println("6. Sortera");
        System.out.println("7. Kontrollera lån");
        System.out.println("8. Utlåning");
        System.out.println("9. Streams");
        System.out.println("10. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för hämtning av data.
    public static void showFetchMenu() {

        System.out.println("\n--- Hämta data ---");
        System.out.println("1. Hämta böcker");
        System.out.println("2. Hämta tidningar");
        System.out.println("3. Hämta användare");
        System.out.println("4. Hämta avstängda användare");
        System.out.println("5. Hämta media");
        System.out.println("6. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för utskrift av data.
    public static void showDisplayMenu() {
        System.out.println("\n--- Visa data ---");
        System.out.println("1. Visa böcker");
        System.out.println("2. Visa tidningar");
        System.out.println("3. Visa användare");
        System.out.println("4. Visa avstängda användare");
        System.out.println("5. Visa media");
        System.out.println("6. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för att lägga till objekt.
    public static void showAddMenu() {
        System.out.println("\n--- Lägg till ---");
        System.out.println("1. Lägg till bok");
        System.out.println("2. Lägg till tidning");
        System.out.println("3. Lägg till användare");
        System.out.println("4. Stäng av användare");
        System.out.println("5. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för borttagning av objekt.
    public static void showDeleteMenu() {
        System.out.println("\n--- Ta bort ---");
        System.out.println("1. Ta bort bok");
        System.out.println("2. Ta bort tidning");
        System.out.println("3. Ta bort användare");
        System.out.println("4. Ta bort avstängning");
        System.out.println("5. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för sökning.
    public static void showSearchMenu() {
        System.out.println("\n--- Sök ---");
        System.out.println("1. Sök bok med titel");
        System.out.println("2. Sök tidning med titel");
        System.out.println("3. Sök användare med email");
        System.out.println("4. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för sortering.
    public static void showSortMenu() {
        System.out.println("\n--- Sortera ---");
        System.out.println("1. Sortera böcker efter titel");
        System.out.println("2. Sortera tidningar efter titel");
        System.out.println("3. Sortera användare efter namn");
        System.out.println("4. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för utlåning och återlämning.
    public static void showLoanMenu() {
        System.out.println("\n--- Utlåning ---");
        System.out.println("1. Låna bok");
        System.out.println("2. Låna tidning");
        System.out.println("3. Låna media");
        System.out.println("4. Lämna tillbaka bok");
        System.out.println("5. Lämna tillbaka tidning");
        System.out.println("6. Lämna tillbaka media");
        System.out.println("7. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }

    // Visar undermeny för stream-funktioner.
    public static void showStreamMenu() {

        System.out.println("\n--- Streams ---");
        System.out.println("1. Visa böcker efter genre");
        System.out.println("2. Visa böcker efter författare");
        System.out.println("3. Sortera böcker efter författare");
        System.out.println("4. Räkna böcker av författare");
        System.out.println("5. Visa alla boktitlar");
        System.out.println("6. Tillbaka");
        System.out.print("Välj ett alternativ: ");
    }
}