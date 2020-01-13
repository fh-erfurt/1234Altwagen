package de.altwagen.user;

import de.altwagen.Request.REQUEST_STATUS;
import de.altwagen.domain.Address;
import de.altwagen.Request.Request;
import de.altwagen.domain.CAR_STATUS;
import de.altwagen.domain.Car;

public class Employee extends User {

    public Employee(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }


    public boolean sellCar(Car car, float price){
        car.setPrice(price);
        return sellCar(car);
    }

    public boolean sellCar(Car car){
        car.setStatus(CAR_STATUS.forSale);

        //TODO Java2: save in DB
        return false;
    }


    public boolean acceptRequest(Request request){
        request.setEmployee(this);
        request.setStatus(REQUEST_STATUS.accepted);
        request.getCustomer().decreaseRequestCount();
        // TODO Java2: save changes in DB
        request.getCar().setStatus(CAR_STATUS.notReadyForSale);
        return false;
    }

    public boolean denyRequest(Request request){
        request.setEmployee(this);
        request.setStatus(REQUEST_STATUS.denied);
        request.getCustomer().decreaseRequestCount();
        // TODO Java2: save changes in DB
        return false;
    }

    public Request[] listPendingRequests(){
        // TODO Java2: Hole alle Request aus der DB mit EmployeeId = -1
        return null;
    }

}
