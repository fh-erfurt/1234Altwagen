package de.altwagen.user;

import de.altwagen.domain.Address;

import java.util.ArrayList;
import java.util.ListIterator;

public class UserManager {

    private static UserManager instance;

    private ArrayList<User> users;

    private UserManager()
    {
        users = new ArrayList<>();
    }

    public static UserManager getInstance()
    {
        if(instance == null)
            instance = new UserManager();
        return instance;
    }

    public static void clearInstance()
    {
        instance = null;
    }

    /**
     * Register new customer if the email is unique
     * @param firstname
     * @param lastname
     * @param eMail
     * @param password
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return new registered customer or null if a customer with that email already exists
     */
    public Customer registerCustomer(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber) {
        Address address = new Address(country, city, postcode, street, houseNumber);
        Customer newCustomer = new Customer(firstname, lastname, eMail, password, address);

        User user = registerUser(newCustomer, false);
        return  user != null ? (Customer) user : null;
    }

    /**
     *  Register new employee if the email is unique
     * @param firstname
     * @param lastname
     * @param eMail
     * @param password
     * @param country
     * @param city
     * @param postcode
     * @param street
     * @param houseNumber
     * @return new registered employee or null if a employee with that email already exists
     */
    public Employee registerEmployee(String firstname, String lastname, String eMail, String password, String country, String city, String postcode, String street, String houseNumber) {
        Address address = new Address(country, city, postcode, street, houseNumber);
        Employee newEmployee = new Employee(firstname, lastname, eMail, password, address);

        User user = registerUser(newEmployee, false);
        return  user != null ? (Employee) user : null;
    }

    /**
     * remove user with the specific email address
     * @param email
     * @return true, if user was found, false otherwise
     */
    public boolean deleteUser(String email){
        boolean success = false;
        for (User user : users) {
            if (user.getEMail().equals(email)) {
                users.remove(user);
                success = true;
                break;
            }
        }
        return success;
    }

    /**
     * search in the List for a user with the given email
     * @param email
     * @return user with given email, null if no user is found
     */
    public User getUserByEMail(String email){
        for (User user : users) {
            if (user.getEMail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    // private functions

    private User registerUser(User newUser, boolean isEmployee){
        for (User user : users) {
            if (user.getEMail().equals(newUser.getEMail())) {
                return null;
            }
        }
        users.add(newUser);
        return  newUser;
    }

}
