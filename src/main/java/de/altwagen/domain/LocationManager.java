package de.altwagen.domain;

import java.util.ArrayList;
import java.util.ListIterator;

public class LocationManager {
    private static LocationManager instance;

    private ArrayList<Location> locations;

    private LocationManager()
    {
        locations = new ArrayList<>();
    }

    public static LocationManager getInstance()
    {
        if(instance == null)
            instance = new LocationManager();
        return instance;
    }

    public static void clearInstance()
    {
        instance = null;
    }

    public Location addLocation(String country, String city, String postcode, String street, String houseNumber, String name, int maxCars, int carCount) {
        Address address = new Address(country, city, postcode, street, houseNumber);
        //check if location is already in list (check for address and name)
        for (Location location : locations) {
            if (location.getAddress().equals(address) && location.getName().equals(name)) {
                return null;
            }
        }
        Location newLocation = new Location(address, name, maxCars, carCount);
        locations.add(newLocation);

        return newLocation;
    }

    /**
     * delete location with given address and name
     * @param address
     * @param name
     * @return true if location is successful deleted, false if no location with this address and name exists
     */
    public boolean deleteLocation(Address address, String name){
        boolean success = false;
        for (Location location : locations) {
            if (location.getAddress().equals(address) && location.getName().equals(name)) {
                locations.remove(location);
                success = true;
                break;
            }
        }
        return success;
    }
}
