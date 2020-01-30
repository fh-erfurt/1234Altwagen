package de.altwagen.domain;

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
        Location location = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50, 25);
        assertNotNull(location, "location should be added!");
    }

   @Test
    void locationShouldBeDeleted(){

        // Kein Plan ob das hier stimmt

        Location location = locationManager.addLocation("Deutschland", "Erfurt", "99085", "Altonaer Straße", "1a", "Geschäftstelle", 50, 25);

        // Prerequisite: location has to be added before deleting it
        assertNotNull(location, "prerequisite failed: location should be added");

        // Test
       assertTrue(locationManager.deleteLocation(location.getAddress(),location.getName()));
    }

    @Test
    void shouldShowLocationsWithAvailableSpace(){
        // TODO
    }
}
