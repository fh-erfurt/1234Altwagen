package de.altwagen.core;

import de.altwagen.domain.Address;
import de.altwagen.domain.CAR_STATUS;
import de.altwagen.domain.Car;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;
import de.altwagen.user.User;

public class Controller {

    //Variablen erstmal alles public


    //Methoden erstmal alles public

    /**
     * Register new customer and save him in DB
     * @param firstname
     * @param lastname
     * @param eMail
     * @param password
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return new registered customer
     */
    public static User registerCustomer(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber) {
        Address address = new Address(country, city, postcode, street, houseNumber);
        User user = new Customer(firstname, lastname, eMail, password, address);

        return registerUser(user, false);
    }

    /**
     *  Register new employee and save him in DB
     * @param firstname
     * @param lastname
     * @param eMail
     * @param password
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return
     */
    public static User registerEmployee(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber) {
            Address address = new Address(country, city, postcode, street, houseNumber);
            User user = new Employee(firstname, lastname, eMail, password, address);

            return registerUser(user, true);
    }

    private static User registerUser(User user, boolean isEmployee){
        try{

            // TODO Java2: add user to DB
            return user;
        }
        catch (Exception ex /*TODO specify Exception*/){
            // TODO handle Exception (e.g. Error Message)
            return null;
        }

    }

    /**
     * Lösche den Nutzer anhand seiner userId
     * @param userId
     * @return true, wenn Löschung erfolgreich, false andernfalls.
     */
    public static boolean deleteUser(int userId){
        // TODO Java2: delete user from DB
        boolean success = false;
        return success;
    }

    public static Car[] getAllCars(){
        // TODO Java2: get all Cars from DB
        Car[] cars = null;
        return cars;
    }

    public static Car[] getCarsByStatus(CAR_STATUS status){
        // TODO Java2: get all Cars with this status from DB
        Car[] cars = null;
        return cars;
    }
}
