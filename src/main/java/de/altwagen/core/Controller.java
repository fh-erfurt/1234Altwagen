package de.altwagen.core;

import de.altwagen.domain.Address;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;
import de.altwagen.user.User;

public class Controller {

    //Variablen erstmal alles public


    //Methoden erstmal alles public

    /**
     * Fügt neuen Nutzer in der Datenbank an.
     * @param firstname
     * @param lastname
     * @param eMail
     * @param password
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return neu registrierten Nutzer.
     */
    public static User registerCustomer(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber)
    {
        Address address = new Address(country, city, postcode, street, houseNumber);
        User user = new Customer(firstname, lastname, eMail, password, address);

        return registerUser(user, false);
    }

    public static User registerEmployee(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber)
    {
            Address address = new Address(country, city, postcode, street, houseNumber);
            User user = new Employee(firstname, lastname, eMail, password, address);

            return registerUser(user, true);
    }

    private static User registerUser(User user, boolean isEmployee){
        try{

            // TODO Java2: füge Nutzer in DB hinzu
            return user;
        }
        catch (Exception ex /*TODO specify Exception*/)

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
