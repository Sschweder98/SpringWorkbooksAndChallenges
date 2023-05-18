package com.ltp.contacts.exception;

public class ContactNotFoundException extends Exception{
    public ContactNotFoundException(String id) { //constructor gets called when exception is thrown
        super("The id '" + id + "' does not exist in our records"); //passing an error message into the parent constructor allows us to access it later...
    }

}
