package de.altwagen.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    void beforeEach(){
        UserManager.clearInstance();
        userManager = UserManager.getInstance();
    }

    @Test
    void customerShouldBeRegistered() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        assertNotNull(customer, "customer should be registered!");
    }

    @Test
    void employeeShouldBeRegistered() {
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        assertNotNull(employee, "employee should be registered!");
    }

    @Test
    void usersShouldBeDeleted() {

        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm2@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: users has to be registered before deleting him
        assertNotNull(customer, "prerequisite failed: customer should be registered!");
        assertNotNull(employee, "prerequisite failed: employee should be registered!");

        // test
        assertTrue(userManager.deleteUser(customer.eMail), "customer should be deleted!");
        assertTrue(userManager.deleteUser(employee.eMail), "customer should be deleted!");
    }

    @Test
    void usersShouldBeFoundByEmail(){
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm2@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: customer has to be registered
        assertNotNull(customer, "prerequisite failed: customer should be registered!");
        assertNotNull(employee, "prerequisite failed: employee should be registered!");

    // test
        Customer newCustomer = (Customer) userManager.getUserByEMail(customer.eMail);
        assertEquals(newCustomer, customer, "newCustomer and customer should be identical!");
        Employee newEmployee = (Employee) userManager.getUserByEMail(employee.eMail);
        assertEquals(newEmployee, employee, "newEmployee and employee should be identical!");
    }

    @Test
    void tmp(){
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        customer.setFirstname("Mario");
        Customer c = (Customer) userManager.getUserByEMail(customer.getEMail());
        assertEquals(c.firstname, customer.firstname);
    }
}
