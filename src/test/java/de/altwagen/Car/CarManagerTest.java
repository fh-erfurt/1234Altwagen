package de.altwagen.Car;

import de.altwagen.Exceptions.CarCountBelowZeroException;
import de.altwagen.domain.Address;
import de.altwagen.domain.Location;
import de.altwagen.domain.LocationManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static de.altwagen.Car.CarStatus.NOT_READY_FOR_SALE;
import static org.junit.jupiter.api.Assertions.*;

public class CarManagerTest {

    private CarManager carManager;
    private LocationManager locationManager;

    private Address musterAddress;
    private Location musterLocation;

    @BeforeEach
    void beforeEach(){
        CarManager.clearInstance();
        carManager = CarManager.getInstance();
        LocationManager.clearInstance();
        locationManager = LocationManager.getInstance();

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

    @Test
    void shouldListCarsWithThisStatus() {
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note", NOT_READY_FOR_SALE);

        ArrayList<Car> carss;
        carss = new ArrayList<>();
        carss.add(car);

        assertEquals(carManager.listCarsByStatus(NOT_READY_FOR_SALE),carss,"should list car");

    }

    @Test
    void shouldListCarsWithThisLocation() {
        Location location = locationManager.addLocation("germany","Erfurt", "99086", "LeuneburgUfer", "2","Test",5);
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note", NOT_READY_FOR_SALE);
        Car car2 = carManager.addNewCar("z1a2b3c4e","2000", 123, "Tesla", "Testmodel","Note", NOT_READY_FOR_SALE);

        try{
            location.addCar(car);
        }
        catch (CarCountBelowZeroException ex){
            fail("CarCountBelowZeroException should not be thrown");
        }

        assertTrue(carManager.listCarsByLocation(location).contains(car),"car should be in list");
        assertFalse(carManager.listCarsByLocation(location).contains(car2),"car2 should not be in list");

    }
}
