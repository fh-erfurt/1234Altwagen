package de.altwagen.Exceptions;

import de.altwagen.domain.Location;

/**
 * This Exception will be thrown, when you try to remove a car from a locations where the car count is already 0
 */
public class CarCountBelowZeroException extends Exception{
    private Location location;

    public CarCountBelowZeroException(Location location){
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
