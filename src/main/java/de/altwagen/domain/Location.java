package de.altwagen.domain;

public class Location {

    //Class variables all private
    private Address address;
    private String name;
    private final int maxCars;  // should the maximum of cars that can be stored at a location be variable??
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

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    //endregion

//eine funktion zum ändern des standortes/zum aktualisieren?

    // public Car[] getAllCars()

}
