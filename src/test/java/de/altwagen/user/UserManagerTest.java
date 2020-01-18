package de.altwagen.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void customerShouldBeDeleted() {

        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: customer has to be registered before deleting him
        assertNotNull(customer, "prerequisite failed: customer should be registered!");

        // test
        assertTrue(userManager.deleteCustomer(customer.eMail), "customer should be deleted!");
    }

    @Test
    void employeeShouldBeRegistered() {
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        assertNotNull(employee, "employee should be registered!");
    }

    @Test
    void employeeShouldBeDeleted() {
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: employee has to be registered before deleting him
        assertNotNull(employee, "prerequisite failed: employee should be registered!");

        // test
        assertTrue(userManager.deleteEmployee(employee.eMail), "employee should be deleted!");
    }

    @Test
    void customerShouldBeFoundByAGivenEmail(){
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: customer has to be registered
        assertNotNull(customer, "prerequisite failed: customer should be registered!");

        // test
        Customer newCustomer = userManager.getCustomerByEMail(customer.eMail);
        assertEquals(newCustomer, customer, "newCustomer and customer should be identical!");
    }

    @Test
    void employeeShouldBeFoundByAGivenEmail(){
        Employee employee = userManager.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: employee has to be registered
        assertNotNull(employee, "prerequisite failed: employee should be registered!");

        // test
        Employee newEmployee = userManager.getEmployeeByEMail(employee.eMail);
        assertEquals(newEmployee, employee, "newEmployee and employee should be identical!");
    }
}
