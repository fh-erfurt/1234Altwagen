package de.altwagen.Request;

import de.altwagen.Car.Car;
import de.altwagen.user.Customer;

import java.util.ArrayList;
import java.util.ListIterator;

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
     * @return added request or null if request with same type, car, customer and REQUEST_STATUS not denied exists
     */
    public Request addRequest(REQUEST_TYPE type, Car car, Customer customer, float price) {

        for (Request request : requests) {
            if (request.getType() == type &&
                    car.equals(request.getCar()) &&
                    customer.equals(request.getCustomer()) &&
                    request.getStatus() != REQUEST_STATUS.denied) {
                return null;
            }
        }
        Request newRequest = new Request(type, car, customer, price);
        requests.add(newRequest);

        return newRequest;
    }

}