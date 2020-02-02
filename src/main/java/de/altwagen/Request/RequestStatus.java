package de.altwagen.Request;

/**
 * This Enumeration defines different status of a request
 */
public enum RequestStatus
{
    PENDING,    // new request
    ACCEPTED,   // employee accepted request
    DENIED,     // employee denied request
    CANCELLED   // customer cancelled request
}
