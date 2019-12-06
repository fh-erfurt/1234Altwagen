package de.altwagen.core;

import de.altwagen.domain.Address;
import de.altwagen.user.Customer;
import de.altwagen.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void customerShouldBeRegistered() {


        User user = Controller.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        assertTrue(user.getUserId() > 0, "customer should be registered!");
        assertTrue( user instanceof Customer, "new user should be instance of Customer!");
    }

    @Test
    void customerShouldBeDeleted() {

        User user = Controller.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: user has to be registered before deleting him
        assertTrue(user.getUserId() > 0, "prerequisite failed: customer should be registered!");

        // Eigentlicher Test
        assertTrue(Controller.deleteUser(user.getUserId()), "user should be deleted!");
    }

    @Test
    void employeeShouldBeRegistered() {


        User user = Controller.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        assertTrue(user.getUserId() > 0, "employee should be registered!");
        assertTrue( user instanceof Customer, "new user should be instance of employee!");
    }

    @Test
    void employeeShouldBeDeleted() {

        User user = Controller.registerEmployee("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        // Prerequisite: user has to be registered before deleting him
        assertTrue(user.getUserId() > 0, "prerequisite failed: employee should be registered!");

        // Eigentlicher Test
        assertTrue(Controller.deleteUser(user.getUserId()), "user should be deleted!");
    }
}