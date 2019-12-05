package de.altwagen.core;

import de.altwagen.domain.Address;
import de.altwagen.user.Customer;
import de.altwagen.user.User;

public class Controller {

    //Variablen erstmal alles public


    //Methoden erstmal alles public

    /**
     * Fügt neuen Nutzer in der Datenbank an.
     * @param user Nutzer der hinzugefügt werden soll
     * @return userId von neu registrierten Nutzer, -1 wenn kein user erstellt wurde.
     */
    public static int registerUser(User user)
    {
        // TODO Java2: füge Nutzer in DB hinzu

        int userId = -1;
        return userId;
    }

    /**
     * Fügt neuen Nutzer in der Datenbank an.
     * @param firstname
     * @param lastname
     * @param eMail
     * @param passwort
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return userId von neu registrierten Nutzer, -1 wenn kein user erstellt wurde.
     */
    public static int registerUser(String firstname, String lastname, String eMail, String passwort, String country, String city, String postcode, String street, String houseNumber)
    {
        Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1");
        User user = new Customer("Max", "Mustermann", "max.mustermann@fh-erfurt.de", "1234", address);

        registerUser(user);
    }



    /**
     * Lösche den Nutzer anhand seiner userId
     * @param userId
     * @return true, wenn Löschung erfolgreich, false andernfalls.
     */
    public static boolean deleteUser(int userId){
        // TODO Java2: Lösche Nutzer aus DB
        boolean success = false;
        return success;
    }
}
