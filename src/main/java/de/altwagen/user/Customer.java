package de.altwagen.user;

import de.altwagen.Request.RequestStatus;
import de.altwagen.domain.Address;
import de.altwagen.Car.Car;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestType;

public class Customer extends User {

    private int requestCount = 0;
    private final int maxRequests = 2;

    public Customer(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }

    /**
     * starts a new request to sell a car
     * @param car
     * @param price
     * @return new generated request
     */
    public Request requestSellCar(Car car, float price){
        return createRequest(car, RequestType.SELL, price);
    }

    /**
     * starts a new request to buy a car
     * @param car
     * @param price
     * @return new generated request
     */
    public Request  requestBuyCar(Car car, float price){
        return createRequest(car, RequestType.BUY, price);
    }

    /**
     * deletes pending request
     * @param request
     * @return true, if deletion successful
     */
    public boolean cancelRequest(Request request){
        boolean result = false;
        if(request.getStatus() == RequestStatus.PENDING){
            //TODO Java2 delete Request from DB
            // result = true;
        }
        return result;
    }

    /**
     * decreases the request count by 1
     */
    public void decreaseRequestCount(){
        requestCount--;
        if(requestCount<0){
            //TODO Error or set to 0?
            // this should never happen!
            requestCount = 0;
        }
    }

    /**
     * creates a new request
     * @param car
     * @param type type of the request (see {@link RequestType})
     * @param price
     * @return newly created request
     */
    private Request createRequest(Car car, RequestType type, float price) {
        // TODO Java2: get request count (is this necessary here?)

        if(requestCount < maxRequests){
            requestCount++;
            Request request = new Request(type, car, this, price);
            // TODO Java2: save request in DB (maybe not here in code?)
            return  request;
        }
        else{
            // customer has too many pending requests
            return null;
        }
    }


}
