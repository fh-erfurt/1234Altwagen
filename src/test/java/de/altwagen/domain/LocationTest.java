package de.altwagen.domain;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarStatus;
import de.altwagen.Exceptions.CarCountBelowZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {


    @Test
    public void carShouldBeAddedToDifferentLocations(){
        Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a");
        Address address2 = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1b");
        Location location1 = new Location(address, "Haus A", 50);
        Location location2 = new Location(address2, "Haus A", 50);
        Car car = new Car("123ABC", "2000", 1000, "VW", "Golf", "blau",null, CarStatus.FOR_SALE);

        try {
            assertTrue(location1.addCar(car), "car should be added to location1!");
            assertEquals(location1.getCarCount(), 1, "car count of location1 should be increased by 1!");
            assertEquals(car.getLocation(), location1, "car location should be set to location1!");

            assertTrue(location2.addCar(car), "car should be added to location2!");
            assertEquals(location2.getCarCount(), 1, "car count of location2 should be increased by 1!");
            assertEquals(location1.getCarCount(), 0, "car count of location1 should be decreased by 1!");
            assertEquals(car.getLocation(), location2, "car location should be set to location2!");
        }
        catch (CarCountBelowZeroException ex){
             fail("CarCountBelowZeroException should not be thrown!");
        }
    }

    @Test
    public void carShouldNotBeAddedToLocationWithNoAvailableSpace(){
        Address address = new Address("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a");
        Location location = new Location(address, "Haus A", 1);
        Car car1 = new Car("123ABC", "2000", 1000, "VW", "Golf", "blau",null, CarStatus.FOR_SALE);
        Car car2 = new Car("123ABD", "2000", 1000, "VW", "Golf", "blau",null, CarStatus.FOR_SALE);

        try {
            assertTrue(location.addCar(car1), "prerequisite: car should be added to location!");
            assertEquals(location.getCarCount(), 1, "prerequisite: car count of location should be increased by 1!");

            assertFalse(location.addCar(car2), "location should not have available space for the car!");
        }
        catch (CarCountBelowZeroException ex){
            fail("CarCountBelowZeroException should not be thrown!");
        }
    }

}