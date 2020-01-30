package de.altwagen.Car;

import de.altwagen.domain.Address;
import de.altwagen.domain.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CarManagerTest {
    private CarManager carManager;

    private Address musterAddress;
    private Location musterLocation;

    @BeforeEach
    void beforeEach(){
        CarManager.clearInstance();
        carManager = CarManager.getInstance();
        musterAddress = new Address("Musterland", "Musterstadt", "99085", "Musterstraße", "1");
        musterLocation = new Location(musterAddress, "Gebäude A", 50, 25);
    }

    @Test
    void carShouldBeAdded(){
        Car musterCar = carManager.addNewCar("123ABC", "2000", 1000, "VW", "Golf", "blau", musterLocation, CarStatus.FOR_SALE);
        assertNotNull(musterCar, "car should be added");
    }

    @Test
    void carShouldBeAddedOrChanged(){

        // Kein Plan ob das hier stimmt

        Car musterCar = carManager.addNewCar("123ABC", "2000", 1000, "VW", "Golf", "blau", musterLocation, CarStatus.FOR_SALE);

        // Prerequisite: car has to be added before changing it
        assertNotNull(musterCar, "prerequisite failed: car should be added!");

        // test
        Car newCar = (Car) carManager.getCarByChassisNumber(musterCar.getChassisNumber());
        assertEquals(newCar, musterCar, "newCar and musterCar should be equal");
    }
}
