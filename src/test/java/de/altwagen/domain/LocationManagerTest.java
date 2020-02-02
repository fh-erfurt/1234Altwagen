package de.altwagen.domain;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarStatus;
import de.altwagen.Exceptions.CarCountBelowZeroException;
import de.altwagen.Exceptions.DeleteLocationWithCarsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LocationManagerTest {

    private LocationManager locationManager;

    @BeforeEach
    void beforeEach(){
        LocationManager.clearInstance();
        locationManager = LocationManager.getInstance();
    }

    @Test
    void locationShouldBeAdded(){
        Location location = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50);
        assertNotNull(location, "location should be added!");
    }

   @Test
    void locationShouldBeDeleted(){
        Location location = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50);

        // Prerequisite: location has to be added before deleting it
        assertNotNull(location, "prerequisite failed: location should be added");

        // Test
       try{
           assertTrue(locationManager.deleteLocation(location.getAddress()));
       }
       catch (DeleteLocationWithCarsException ex){
           fail("DeleteLocationWithCarsException should not be thrown!");
       }
    }

    @Test
    void locationShouldNotBeDeleted(){
        Location location = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50);
        Car car = new Car("123ABC", "2000", 1000, "VW", "Golf", "blau",null, CarStatus.FOR_SALE);

        // Prerequisite: location has to be added before deleting it
        try {
            assertNotNull(location, "prerequisite failed: location should be added");
            assertTrue(location.addCar(car), "prerequisite: car should be added to location!");
            assertEquals(location.getCarCount(), 1, "prerequisite: car count of location should be increased by 1!");
        }
        catch (CarCountBelowZeroException ex){
            fail("CarCountBelowZeroException should not be thrown!");
        }

        // Test
        try{
            locationManager.deleteLocation(location.getAddress());
            fail("DeleteLocationWithCarsException should be thrown!");
        }
        catch (DeleteLocationWithCarsException ex){
            assertEquals(ex.getLocation(), location,"DeleteLocationWithCarsException should know the location, where the exception was thrown!");
        }
    }

    @Test
    void shouldShowLocationsWithAvailableSpace(){
        Location location1 = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50);
        Location location2 = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1b", "Geschäftstelle", 10);
        Location location3 = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1c", "Geschäftstelle", 3);

        assertNotNull(location1, "prerequisite failed: location1 should be added");
        assertNotNull(location2, "prerequisite failed: location2 should be added");
        assertNotNull(location3, "prerequisite failed: location3 should be added");

        ArrayList<Location> locations = locationManager.getLocationsWithAvailableSpace(8);
        assertTrue(locations.contains(location1), "location1 should be in the list of locations with enough space!");
        assertTrue(locations.contains(location2), "location1 should be in the list of locations with enough space!");
        assertFalse(locations.contains(location3), "location1 should not be in the list of locations with enough space!");
    }
}
