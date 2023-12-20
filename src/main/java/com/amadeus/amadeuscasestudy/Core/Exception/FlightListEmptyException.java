package com.amadeus.amadeuscasestudy.Core.Exception;

public class FlightListEmptyException extends EntityListEmptyException {
    public FlightListEmptyException() {
        super("FlightList is empty.");
    }

    public FlightListEmptyException(String s) {
        super(s);
    }
}
