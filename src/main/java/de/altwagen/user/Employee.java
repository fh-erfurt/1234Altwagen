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

    //Methoden erstmal alles public
    public boolean sellCar(Car car, float price){
        car.setStatus(CAR_STATUS.forSale);
        car.setPrice(price);

        //TODO Java2: save in DB
        return false;
    }


    public void acceptRequest(Request request){
        // TODO Java2 DB
        request.setEmployee(this);
        request.setREQUESTStatus(REQUEST_STATUS.accepted);
    }

    public void denyRequest(Request request){

    }

    public Request[] listUnassignedRequests(){
        // TODO Java2: Hole alle Request aus der DB mit EmployeeId = -1
        return null;
    }

}
