package de.altwagen.user;


import de.altwagen.Car.Car;
import de.altwagen.Car.CarManager;
import de.altwagen.Car.CarStatus;
import de.altwagen.Exceptions.CarCountBelowZeroException;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestManager;
import de.altwagen.Request.RequestStatus;
import de.altwagen.domain.Location;
import de.altwagen.domain.LocationManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static de.altwagen.Car.CarStatus.FOR_SALE;
import static de.altwagen.Car.CarStatus.NOT_READY_FOR_SALE;
import static de.altwagen.Request.RequestStatus.*;
import static de.altwagen.Request.RequestType.BUY;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private UserManager userManager;
    private LocationManager locationManager;
    private RequestManager requestManager;
    private CarManager carManager;

    @BeforeEach
    void beforeEach(){

        UserManager.clearInstance();
        userManager = UserManager.getInstance();

        LocationManager.clearInstance();
        locationManager = LocationManager.getInstance();

        RequestManager.clearInstance();
        requestManager = RequestManager.getInstance();

        CarManager.clearInstance();
        carManager = CarManager.getInstance();
    }


    @Test
    void requestShouldBeAccepted() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);
        request.setStatus(PENDING);

        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm2@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");


        assertEquals(employee.acceptRequest(request),true,"Request Status should be accepted");

    }



    @Test
    void locationShouldBeChanged() throws CarCountBelowZeroException {
        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note", CarStatus.NOT_READY_FOR_SALE);
        Location location = locationManager.addLocation("england","London", "99086", "LeuneburgUfer", "2","Test",5);

        employee.changeCarLocation(car,location);
        assertEquals(car.getLocation(), location,"car location should be new location");

    }

    @Test
    void shouldGetLocationswithEnoughSpace() {
        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Location location = locationManager.addLocation("england","London", "99086", "LeuneburgUfer", "2","Test",5);

        ArrayList<Location> locationss;
        locationss = new ArrayList<>();
        locationss.add(location);


        assertEquals(employee.getLocationsWithAvailableSpace(1),locationss,"The one location should be put out");

    }

    @Test
    void shouldGetPendingRequests() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note", NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);
        request.setStatus(RequestStatus.PENDING);

        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm2@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        ArrayList<Request> requestss;
        requestss = new ArrayList<>();
        requestss.add(request);

        assertEquals(requestManager.getRequestsByStatus(RequestStatus.PENDING),requestss,"nd");
        assertEquals(employee.listPendingRequests(),requestss,"should put out the pending request");

    }

    @Test
    void requestShouldBeDenied() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);

        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm2@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        employee.denyRequest(request);

        assertEquals(request.getStatus(), DENIED,"Request status should be denied");

    }

    @Test
    void carShouldBeForSale() {
       Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);

        Employee employee = userManager.registerEmployee("Maxi", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        employee.sellCar(car,5000);

        assertEquals(car.getStatus(),FOR_SALE,"Request should be accepted");

    }
}