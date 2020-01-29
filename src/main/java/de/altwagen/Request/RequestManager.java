package de.altwagen.Request;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarStatus;
import de.altwagen.user.Customer;
import de.altwagen.user.User;

import java.util.ArrayList;

public class RequestManager {
    private static RequestManager instance;

    private ArrayList<Request> requests;

    private RequestManager()
    {
        requests = new ArrayList<>();
    }

    public static RequestManager getInstance()
    {
        if(instance == null)
            instance = new RequestManager();
        return instance;
    }

    public static void clearInstance()
    {
        instance = null;
    }

    /**
     *
     * @param type
     * @param car
     * @param customer
     * @param price
     * @return added request or null if request with same type, car, customer and RequestStatus accepted/cancelled exists
     */
    public Request addRequest(RequestType type, Car car, Customer customer, float price) {
        //check for duplicated request
        for (Request request : requests) {
            if (request.getType() == type &&
                    car.equals(request.getCar()) &&
                    customer.equals(request.getCustomer()) &&
                    (request.getStatus() != RequestStatus.ACCEPTED ||
                    request.getStatus() != RequestStatus.PENDING)) {
                return null;
            }
        }
        car.setStatus(CarStatus.ON_ACTIVE_REQUEST);
        Request newRequest = new Request(type, car, customer, price);
        requests.add(newRequest);

        return newRequest;
    }

    public ArrayList<Request> getRequestsByStatus(RequestStatus status){
        ArrayList<Request> requestList = new ArrayList<>();
        for(Request request : requests){
            if(request.getStatus() == status){
                requestList.add(request);
            }
        }
        return requestList;
    }

    /**
     * search in request list for entries there the user is customer or employee
     * @param user
     * @return ALL requests with the given user as {@link Customer} or {@link de.altwagen.user.Employee}
     */
    public ArrayList<Request> getRequestsByUser(User user){
        ArrayList<Request> requestList = new ArrayList<>();
        for(Request request : requests){
            if(request.getCustomer().equals(user) || request.getEmployee().equals(user)){
                requestList.add(request);
            }
        }
        return requestList;
    }

    public ArrayList<Request> getRequestsByType(RequestType type){
        ArrayList<Request> requestList = new ArrayList<>();
        for(Request request : requests){
            if(request.getType() == type){
                requestList.add(request);
            }
        }
        return requestList;
    }

}
