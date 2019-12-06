package de.altwagen.domain;

public enum CAR_STATUS {
    forSale,            // car can be requested for buying
    notReadyForSale,    // car is in stock but not ready yet to be selled
    onRequest           // car is currently part of a request (buy and sell)
}
