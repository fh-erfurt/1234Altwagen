package de.altwagen.Car;

import de.altwagen.domain.Location;

import java.util.ArrayList;

/**
 * This singleton-class manages all cars. Cars should only be created and deleted through this class.
 */
public class CarManager {
    private static CarManager instance;

    private ArrayList<Car> cars;

    private CarManager()
    {
        cars = new ArrayList<>();
    }

    public static CarManager getInstance()
    {
        if(instance == null)
            instance = new CarManager();
        return instance;
    }

    public static void clearInstance()
    {
        instance = null;
    }

    /**
     * add a new car to the list
     * @param chassisNumber
     * @param constructionYear
     * @param drivenKM
     * @param brand
     * @param model
     * @param note
     * @param status
     * @return added Car or null if a car with the given chassisNumber exists already
     */
    public Car addNewCar(String chassisNumber, String constructionYear, int drivenKM, String brand, String model, String note, CarStatus status) {
        //check if car is already in list (check for chassisNumber)
        if(getIndexOfCarWithChassisNumber(chassisNumber) != -1)
            return null;
        Car car = new Car(chassisNumber, constructionYear, drivenKM, brand, model, note, null, status);
        cars.add(car);

        return car;
    }

    /**
     * add the car to the list if it does not exist or change the car if there exists a car with identical chassisNumber
     * @param car
     * @return
     */
    public boolean addOrChangeCar(Car car)
    {
        int index = getIndexOfCarWithChassisNumber(car.getChassisNumber());
        if(index == -1){
            cars.add(car);
        }
        else {
            cars.set(index, car);
        }
        return true;
    }

    /**
     * delete car with given chassisNumber
     * @param chassisNumber
     */
    public void deleteCar(String chassisNumber){
        cars.removeIf(car -> car.getChassisNumber().equals(chassisNumber));
    }

    /**
     * search in the List for a car with the given chassisNumber
     * @param chassisNumber
     * @return car with given chassisNumber or null if no car is found
     */
    public Car getCarByChassisNumber(String chassisNumber){
        int index = getIndexOfCarWithChassisNumber(chassisNumber);
        if (index == -1)
            return null;
        return cars.get(index);
    }

    /**
     * search in the car array for all cars with the given {@link CarStatus}
     * @param status
     * @return ArrayList of all Cars found, if no car is found an empty ArrayList is returned
     */
    public ArrayList<Car> listCarsByStatus(CarStatus status){
        ArrayList<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (status.equals(car.getStatus())) {
                carList.add(car);
            }
        }
        return carList;
    }

    /**
     * search in the car array for all cars which are at the given {@link Location}
     * @param location
     * @return ArrayList of all Cars at that {@link Location}, if there is no car an empty ArrayList is returned
     */
    public ArrayList<Car> listCarsByLocation(Location location){
        ArrayList<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (location.equals(car.getLocation())) {
                carList.add(car);
            }
        }
        return carList;
    }

    // private functions

    /**
     * search in the List for a car with the given chassisNumber
     * @param chassisNumber
     * @return index of the car with given chassisNumber or -1 if no car is found
     */
    private int getIndexOfCarWithChassisNumber(String chassisNumber){
        for (Car car : cars) {
            if (car.getChassisNumber().equals(chassisNumber)) {
                return cars.indexOf(car);
            }
        }
        return -1;
    }
}
