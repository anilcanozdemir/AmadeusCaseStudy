package com.amadeus.amadeuscasestudy.Core.Exception;

public class AirportNotFoundException extends EntityNotFoundException {


    public AirportNotFoundException(Long id) {
        super("Airport with id  :" + id + " is not found.");
    }
}
