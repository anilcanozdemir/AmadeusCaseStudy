package com.amadeus.amadeuscasestudy.Core.Exception;

public abstract class EntityListEmptyException extends EntityNotFoundException {

    public EntityListEmptyException(String s) {
        super(s);
    }
}
