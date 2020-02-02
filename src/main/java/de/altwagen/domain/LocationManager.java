package de.altwagen.domain;

import de.altwagen.Exceptions.DeleteLocationWithCarsException;

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

    public Location addLocation(String country, String city, String postcode, String street, String houseNumber, String name, int maxCars) {
        Address address = new Address(country, city, postcode, street, houseNumber);
        //check if location is already in list (check for address)
        for (Location location : locations) {
            if (location.getAddress().equals(address)) {
                return null;
            }
        }
        Location newLocation = new Location(address, name, maxCars);
        locations.add(newLocation);

        return newLocation;
    }

    /**
     * delete location with given address and name
     * @param address
     * @return true if location is successful deleted, false if no location with this address and name exists
     * @throws DeleteLocationWithCarsException when a not empty location is deleted
     */
    public boolean deleteLocation(Address address) throws DeleteLocationWithCarsException{
        for (Location location : locations) {
            if (location.getAddress().equals(address)) {
                if(location.getCarCount() != 0){
                    throw new DeleteLocationWithCarsException(location);
                }
                locations.remove(location);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param minSpace minimum available space which the location should have
     * @return ArrayList of {@link Location} with at least the given {@param minSpace}
     */
    public ArrayList<Location> getLocationsWithAvailableSpace(int minSpace){
        ArrayList<Location> locationList = new ArrayList<>();
        for (Location location : locations) {
            if (location.getMaxCars() - location.getCarCount() >= minSpace) {
                locationList.add(location);
            }
        }
        return locationList;
    }
}
