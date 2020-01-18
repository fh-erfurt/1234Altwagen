package de.altwagen.user;

import de.altwagen.domain.Address;

import java.util.ArrayList;
import java.util.ListIterator;

public class UserManager {

    private static UserManager instance;

    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;

    private UserManager()
    {
        customers = new ArrayList<>();
        employees = new ArrayList<>();
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
        for (Customer customer : customers) {
            if (customer.getEMail().equals(eMail)) {
                return null;
            }
        }

        Address address = new Address(country, city, postcode, street, houseNumber);
        Customer newCustomer = new Customer(firstname, lastname, eMail, password, address);
        customers.add(newCustomer);

        return newCustomer;
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
        for (Employee employee : employees) {
            if (employee.getEMail().equals(eMail)) {
                return null;
            }
        }

        Address address = new Address(country, city, postcode, street, houseNumber);
        Employee newEmployee = new Employee(firstname, lastname, eMail, password, address);
        employees.add(newEmployee);

        return newEmployee;
    }

    /**
     * remove employee with the specific email address
     * @param email
     * @return true, if employee was found, false otherwise
     */
    public boolean deleteEmployee(String email){
        boolean success = false;
        for (Employee employee : employees) {
            if (employee.getEMail().equals(email)) {
                employees.remove(employee);
                success = true;
                break;
            }
        }
        return success;
    }

    /**
     * remove customer with the specific email address
     * @param email
     * @return true, if customer was found, false otherwise
     */
    public boolean deleteCustomer(String email){
        boolean success = false;
        for (Customer customer : customers) {
            if (customer.getEMail().equals(email)) {
                customers.remove(customer);
                success = true;
                break;
            }
        }
        return success;
    }

    /**
     * search in the List for a customer with the given email
     * @param email
     * @return customer with given email, null if no customer is found
     */
    public Customer getCustomerByEMail(String email){
        for (Customer customer : customers) {
            if (customer.getEMail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * search in the List for a employee with the given email
     * @param email
     * @return employee with given email, null if no employee is found
     */
    public Employee getEmployeeByEMail(String email){
        for (Employee employee : employees) {
            if (employee.getEMail().equals(email)) {
                return employee;
            }
        }
        return null;
    }
}
