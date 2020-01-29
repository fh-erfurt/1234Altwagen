package de.altwagen.domain;

import de.altwagen.Car.Car;
import de.altwagen.Exceptions.CarCountBelowZeroException;

public class Location {

    //Class variables all private
    private Address address;
    private String name;
    private int maxCars;
    private int carCount;

    public Location(Address address, String name, int maxCars, int carCount) {
        this.address = address;
        this.name = name;
        this.maxCars = maxCars;
        this.carCount = carCount;
    }

    //region Getter and Setter
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCars() {
        return maxCars;
    }

    public void setMaxCars(int maxCars){
        this.maxCars = maxCars;
    }

    public int getCarCount() {
        return carCount;
    }

    //endregion

    @Override
    public boolean equals(Object o){

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Location or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Location)) {
            return false;
        }

        // typecast o to Location so that we can compare data members
        Location l = (Location) o;

        // Compare the data members and return accordingly
        return address.equals(l.getAddress());
    }

    public boolean addCar(Car car) throws CarCountBelowZeroException{
        if(carCount >= maxCars){
            return false;
        }
        boolean result = false;
        Location oldLocation = car.getLocation();
        if (oldLocation != null){
            result = oldLocation.decreaseCarCount();
        }
        if(result) {
            result = increaseCarCount();
            if(result){
                car.setLocation(this);
            }
        }
        return result;
    }

    public boolean decreaseCarCount() throws CarCountBelowZeroException {
        if(carCount > 0){
            --carCount;
            return true;
        }
        else {
            throw new CarCountBelowZeroException(this);
        }
    }

    private boolean increaseCarCount(){
        if(carCount < maxCars){
            ++carCount;
            return true;
        }
        else {
            return false;
        }
    }

}
