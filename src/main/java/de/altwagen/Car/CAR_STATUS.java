package de.altwagen.Car;

public enum CAR_STATUS {
    forSale,            // car can be requested for buying
    notReadyForSale,    // car is in stock but not ready yet to be selled
    onActiveRequest,    // car is currently part of an active request (buy and sell)
    inactive            // use this status if none of the other applies
}
