package de.altwagen.core;

import de.altwagen.domain.Address;
import de.altwagen.user.Customer;
import de.altwagen.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void customerShouldBeRegistered() {

        Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1");
        User user = new Customer("Max", "Mustermann", "max.mustermann@fh-erfurt.de", "1234", address);

        int userId = Controller.registerUser(user);
        assertTrue(userId > 0, "Nutzer konnte nicht registriert werden!");
    }

    @Test
    void customerShouldBeDeleted() {

        Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1");
        User user = new Customer("Max", "Mustermann", "max.mustermann@fh-erfurt.de", "1234", address);

        int userId = Controller.registerUser(user);

        // Voraussetzung: Nutzer muss registriert sein, um gelöscht zu werden
        assertTrue(userId > 0, "Vorbedingung fehlgeschlagen: Nutzer konnte nicht registriert werden!");

        // Eigentlicher Test
        assertTrue(Controller.deleteUser(userId), "Nutzer konnte nicht gelöscht werden!");
    }
}