package com.ageinghippy.cnitem_microservice.exception;

public class ItemNotFoundException extends Exception{

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
