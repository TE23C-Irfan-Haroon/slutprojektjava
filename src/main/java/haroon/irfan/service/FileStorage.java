package haroon.irfan.service;

import java.util.ArrayList;

import haroon.irfan.model.Loan;

/**
 * Gränssnitt för lagring och inläsning av lån.
 *
 * @author Haroon Irfan
 * @version 1.0
 * @since 2025
 */
public interface FileStorage {

   /**
     * Sparar lån till lagring.
     *
     * @param loans lista med lån
     */
   void saveLoans(ArrayList<Loan> loans);

   /**
    * Läser in lån från lagring.
    *
    * @return lista med lån
    */
   ArrayList<Loan> loadLoans();
}