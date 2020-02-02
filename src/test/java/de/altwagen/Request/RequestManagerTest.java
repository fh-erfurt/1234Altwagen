package de.altwagen.Request;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarManager;
import de.altwagen.domain.LocationManager;
import de.altwagen.user.Customer;
import de.altwagen.user.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static de.altwagen.Car.CarStatus.NOT_READY_FOR_SALE;
import static de.altwagen.Request.RequestStatus.PENDING;
import static de.altwagen.Request.RequestType.BUY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestManagerTest {

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
    void newRequestShouldBeAdded() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",locationManager.addLocation("germany","Erfurt", "99086", "LeuneburgUfer", "2","Test",5, 2),NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);

        assertNotNull(request, "request should be created");
    }

    @Test
    void shouldListRequestsWithThisStatus(){
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",locationManager.addLocation("germany","Erfurt", "99086", "LeuneburgUfer", "2","Test",5, 2),NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);

        ArrayList<Request> requestss;
        requestss = new ArrayList<>();
        requestss.add(request);


        assertEquals(requestManager.getRequestsByStatus(PENDING),requestss,"request should be listed");
    }

    @Test
    void shouldListRequestsWithThisUser() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",locationManager.addLocation("germany","Erfurt", "99086", "LeuneburgUfer", "2","Test",5, 2),NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);

        ArrayList<Request> requestss;
        requestss = new ArrayList<>();
        requestss.add(request);

        assertEquals(requestManager.getRequestsByUser(customer),requestss,"request should be listed");

    }

    @Test
    void shouldListRequestsWithThisType() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",locationManager.addLocation("germany","Erfurt", "99086", "LeuneburgUfer", "2","Test",5, 2),NOT_READY_FOR_SALE);
        Request request = requestManager.addRequest(BUY,car,customer,5000);

        ArrayList<Request> requestss;
        requestss = new ArrayList<>();
        requestss.add(request);


        assertEquals(requestManager.getRequestsByType(BUY),requestss,"request should be listed");

    }



}
