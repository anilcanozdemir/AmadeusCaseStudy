package com.amadeus.amadeuscasestudy.Core.Exception;

public class FlightNotFoundException extends EntityNotFoundException {
    public FlightNotFoundException(Long id) {
        super("Flight with id  :" + id + " is not found.");
    }
}
