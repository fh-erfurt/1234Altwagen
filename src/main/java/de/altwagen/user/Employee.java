package de.altwagen.user;

import de.altwagen.Request.RequestStatus;
import de.altwagen.domain.Address;
import de.altwagen.Request.Request;
import de.altwagen.Car.CarStatus;
import de.altwagen.Car.Car;

public class Employee extends User {

    public Employee(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }


    public boolean sellCar(Car car, float price){
        // TODO
        return false;
    }


    public boolean acceptRequest(Request request){
        request.setEmployee(this);
        request.setStatus(RequestStatus.ACCEPTED);
        request.getCustomer().decreaseRequestCount();
        // TODO Java2: save changes in DB
        request.getCar().setStatus(CarStatus.NOT_READY_FOR_SALE);
        return false;
    }

    public boolean denyRequest(Request request){
        request.setEmployee(this);
        request.setStatus(RequestStatus.DENIED);
        request.getCustomer().decreaseRequestCount();
        // TODO Java2: save changes in DB
        return false;
    }

    public Request[] listPendingRequests(){
        // TODO Java2: Hole alle Request aus der DB mit EmployeeId = -1
        return null;
    }

}
