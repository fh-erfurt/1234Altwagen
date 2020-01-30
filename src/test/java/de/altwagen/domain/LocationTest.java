package de.altwagen.domain;

import de.altwagen.Car.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1b");
    Location location = new Location(address, "Haus A", 50, 25);


}