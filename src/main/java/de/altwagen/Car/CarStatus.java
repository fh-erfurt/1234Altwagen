package de.altwagen.Car;

/**
 * This Enumeration defines different status of a car
 */
public enum CarStatus {
    FOR_SALE,            // car can be requested for buying
    NOT_READY_FOR_SALE,  // car is in stock but not ready to be sold yet
    ON_ACTIVE_REQUEST,   // car is currently part of an active request (buy and sell)
    SOLD,                // car is sold
    INACTIVE             // use this status if none of the other applies
}
