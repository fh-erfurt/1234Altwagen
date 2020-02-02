package de.altwagen.Exceptions;

import de.altwagen.domain.Location;

/**
 * This Exception will be thrown, when you try to delete a location, which has cars stored (carCount not 0)
 */
public class DeleteLocationWithCarsException extends Exception{
    private Location location;

    public DeleteLocationWithCarsException(Location location){
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
