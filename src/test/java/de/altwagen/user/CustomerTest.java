package de.altwagen.user;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarManager;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestManager;
import de.altwagen.domain.LocationManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static de.altwagen.Car.CarStatus.NOT_READY_FOR_SALE;
import static de.altwagen.Request.RequestStatus.CANCELLED;
import static de.altwagen.Request.RequestType.BUY;
import static de.altwagen.Request.RequestType.SELL;
import static org.junit.jupiter.api.Assertions.*;
class CustomerTest {


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
    void shouldCreateRequestSellCar() {
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        Request request = customer.requestSellCar("z1a2b3c4d", "2000", 123, "Tesla", "Testmodel", "Note", 30000);

        assertNotNull(request, "request should be created");
        assertEquals(request.getType(),SELL,"request type should be SELL");

    }

    @Test
    void shouldCreateRequestBuyCar() {

        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        Request request = customer.requestBuyCar(car,5000);

        assertNotNull(request, "request should be created");
        assertEquals(request.getType(),BUY,"request type should be BUY");

    }

    @Test
    void cancelRequest() {

        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        Request request = customer.requestBuyCar(car,5000);
        customer.cancelRequest(request);

        assertEquals(request.getStatus(),CANCELLED,"Request status should be CANCELLED");

    }

    @Test
    void decreaseRequestCount() {
        Car car = carManager.addNewCar("z1a2b3c4d","2000", 123, "Tesla", "Testmodel","Note",NOT_READY_FOR_SALE);
        Customer customer = userManager.registerCustomer("Max", "Mustermann", "mm@fh-erfurt.de", "1234a", "Deutschland", "Erfurt", "99087", "Altonaer Straße", "1");

        Request request = customer.requestBuyCar(car,5000);
        customer.decreaseRequestCount();
        assertEquals(customer.getActiveRequestCount(),0,"Active request count should be 0");

    }

}