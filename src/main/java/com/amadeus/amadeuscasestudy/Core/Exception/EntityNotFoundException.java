package com.amadeus.amadeuscasestudy.Core.Exception;

public abstract class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(String s) {
        super(s);
    }

    public EntityNotFoundException(Long s) {
        super(String.valueOf(s));
    }
}
