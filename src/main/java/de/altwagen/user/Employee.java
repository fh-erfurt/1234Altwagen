package de.altwagen.user;

import de.altwagen.Request.RequestManager;
import de.altwagen.Request.RequestStatus;
import de.altwagen.domain.Address;
import de.altwagen.Request.Request;
import de.altwagen.Car.CarStatus;
import de.altwagen.Car.Car;

import java.util.ArrayList;

public class Employee extends User {

    public Employee(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }


    public boolean sellCar(Car car, float price){
        if(car.getStatus() == CarStatus.NOT_READY_FOR_SALE){
            car.setPrice(price);
            car.setStatus(CarStatus.FOR_SALE);
        }
        return false;
    }


    public boolean acceptRequest(Request request){
        if(request.getStatus() == RequestStatus.PENDING){
            request.setEmployee(this);
            request.setStatus(RequestStatus.ACCEPTED);
            request.getCustomer().decreaseRequestCount();
            request.getCar().setStatus(CarStatus.NOT_READY_FOR_SALE);
            return true;
        }
        return false;
    }

    public boolean denyRequest(Request request){
        if(request.getStatus() == RequestStatus.PENDING) {
            request.setEmployee(this);
            request.setStatus(RequestStatus.DENIED);
            request.getCustomer().decreaseRequestCount();
            return true;
        }
        return false;
    }

    public ArrayList<Request> listPendingRequests(){
        RequestManager requestManager = RequestManager.getInstance();
        return requestManager.getRequestsByStatus(RequestStatus.PENDING);
    }

}
