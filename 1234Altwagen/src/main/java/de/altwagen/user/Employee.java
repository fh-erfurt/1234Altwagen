package de.altwagen.user;

import de.altwagen.domain.Address;
import de.altwagen.domain.Request;
import de.altwagen.user.User;

public class Employee extends User {

    public Employee(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }

    //Methoden erstmal alles public
    public boolean sellCar(int price, int others){
        return false;
    }
    public void acceptRequest(Request request){

    }
    public void cancelRequest(Request request){

    }

    public Request[] listUnassignedRequests(){
        // TODO Java2: Hole alle Request aus der DB mit EmployeeId = -1
        return null;
    }

    public boolean assignRequestToMe(int requestId){
        // TODO Java2: Hole Request aus DB
        Request request = null;

        // Wenn Request nicht aus DB geholt werden konnte
        if(request==null) return false;

        request.setEmployeeId(this.userId);
        return true;
    }
}
