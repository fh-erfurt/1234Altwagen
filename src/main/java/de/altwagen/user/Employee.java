package de.altwagen.user;

import de.altwagen.Exceptions.CarCountBelowZeroException;
import de.altwagen.Request.RequestManager;
import de.altwagen.Request.RequestStatus;
import de.altwagen.Request.RequestType;
import de.altwagen.domain.Address;
import de.altwagen.Request.Request;
import de.altwagen.Car.CarStatus;
import de.altwagen.Car.Car;
import de.altwagen.domain.Location;
import de.altwagen.domain.LocationManager;

import java.util.ArrayList;

/**
 * This extended class of user specifies what the employee is able to do.
 */
public class Employee extends User {

    public Employee(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }


    /**
     * changes {@link CarStatus} from NOT_READY_FOR_SALE to FOR_SALE and sets its price
     * @param car
     * @param price
     * @return true if {@link CarStatus} is NOT_READY_FOR_SALE, false otherwise
     */
    public boolean sellCar(Car car, float price){
        if(car.getStatus() == CarStatus.NOT_READY_FOR_SALE){
            car.setPrice(price);
            car.setStatus(CarStatus.FOR_SALE);
            return true;
        }
        return false;
    }

    /**
     *
     * @param request
     * @return true if successful accepted, false if {@link RequestStatus} is not PENDING
     */
    public boolean acceptRequest(Request request){
        if(request.getStatus() == RequestStatus.PENDING){
            request.setEmployee(this);
            request.setStatus(RequestStatus.ACCEPTED);
            request.getCustomer().decreaseRequestCount();
            if(request.getType().equals(RequestType.SELL)){
                request.getCar().setStatus(CarStatus.NOT_READY_FOR_SALE);
            }
            else{
                request.getCar().setStatus(CarStatus.SOLD);
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @param request
     * @return true if successful denied, false if {@link RequestStatus} is not PENDING
     */
    public boolean denyRequest(Request request){
        if(request.getStatus() == RequestStatus.PENDING) {
            request.setEmployee(this);
            request.setStatus(RequestStatus.DENIED);
            request.getCustomer().decreaseRequestCount();
            return true;
        }
        return false;
    }
    /**
     * changes the {@link Location} element in the car to the given {@link Location}.
     * This will also handle the carCount in the old location and the new location
     * @param car
     * @param location
     * @return true if location was successfully changed, false if the maximum car count of that location is reached.
     * @throws CarCountBelowZeroException
     */
    public boolean changeCarLocation(Car car, Location location) throws CarCountBelowZeroException {
        return location.addCar(car);
    }

    /**
     *
     * @param minSpace minimum available space which the location should have
     * @return ArrayList of {@link Location} with at least the given {@param minSpace}
     */
    public ArrayList<Location> getLocationsWithAvailableSpace(int minSpace){
        LocationManager locationManager = LocationManager.getInstance();
        return locationManager.getLocationsWithAvailableSpace(minSpace);
    }

    /**
     *
     * @return ArrayList of {@link Request} with the {@link RequestStatus} PENDING
     */
    public ArrayList<Request> listPendingRequests(){
        RequestManager requestManager = RequestManager.getInstance();
        return requestManager.getRequestsByStatus(RequestStatus.PENDING);
    }

}
