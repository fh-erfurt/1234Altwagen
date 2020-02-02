package de.altwagen.Exceptions;

import de.altwagen.domain.Location;

public class DeleteLocationWithCarsException extends Exception{
    private Location location;

    public DeleteLocationWithCarsException(Location location){
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
