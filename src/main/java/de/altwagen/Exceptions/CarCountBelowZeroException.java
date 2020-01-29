package de.altwagen.Exceptions;

import de.altwagen.domain.Location;

public class CarCountBelowZeroException extends Exception{
    private Location location;

    public CarCountBelowZeroException(Location location){
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
