package de.altwagen.user;

import de.altwagen.Car.CarManager;
import de.altwagen.Car.CarStatus;
import de.altwagen.Request.RequestManager;
import de.altwagen.Request.RequestStatus;
import de.altwagen.domain.Address;
import de.altwagen.Car.Car;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestType;

import java.util.ArrayList;

public class Customer extends User {

    private int requestCount = 0;
    private final int maxRequests = 2;

    public Customer(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }

    public int getActiveRequestCount(){
        return requestCount;
    }

    public int getMaximumRequestCount(){
        return maxRequests;
    }

    public Request requestSellCar(String chassisNumber, String constructionYear, int drivenKM, String brand, String model, String note, float price){
        CarManager carManager = CarManager.getInstance();
        Car car = carManager.addNewCar(chassisNumber, constructionYear, drivenKM, brand, model, note, CarStatus.INACTIVE);

        if(car != null) {
            return requestSellCar(car, price);
        }
        else{
            return null;
        }
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
     * sets the {@link RequestStatus} to CANCELLED if the request is PENDING
     * @param request
     * @return true, if cancelling successful
     */
    public boolean cancelRequest(Request request){
        boolean result = false;
        if(request.getStatus() == RequestStatus.PENDING){
            request.setStatus(RequestStatus.CANCELLED);
            decreaseRequestCount();
            result = true;
        }
        return result;
    }

    /**
     * decreases the request count by 1
     */
    public void decreaseRequestCount(){
        if(--requestCount < 0){
            requestCount = 0;
        }
    }


    /**
     * creates a new request if the user has not already the maximum count of active requests
     * @param car
     * @param type type of the request (see {@link RequestType})
     * @param price
     * @return newly created request, null otherwise
     */
    private Request createRequest(Car car, RequestType type, float price) {
        if(requestCount < maxRequests){
            ++requestCount;
            RequestManager requestManager = RequestManager.getInstance();
            Request request = requestManager.addRequest(type, car, this, price);
            return  request;
        }
        else{
            // customer has too many pending requests
            return null;
        }
    }


}
