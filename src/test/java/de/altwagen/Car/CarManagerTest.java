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
        musterLocation = new Location(musterAddress, "Gebäude A", 50);
    }

    @Test
    void carShouldBeAdded(){
        Car musterCar = carManager.addNewCar("123ABC", "2000", 1000, "VW", "Golf", "blau", CarStatus.FOR_SALE);
        assertNotNull(musterCar, "car should be added");
    }

    @Test
    void carShouldBeAddedAndChanged(){
        Car musterCar = new Car("123ABC", "2000", 1000, "VW", "Golf", "blau", null, CarStatus.FOR_SALE);

        carManager.addOrChangeCar(musterCar);

        assertEquals(carManager.getCarByChassisNumber("123ABC"), musterCar, "car should be added!");

        Car newCar = new Car("123ABC", "2000", 1000, "VW", "Golf", "red", null, CarStatus.FOR_SALE);
        carManager.addOrChangeCar(newCar);

        assertEquals(carManager.getCarByChassisNumber("123ABC").getNote(), "red", "car should be changed");

    }
}
