package javaassignments;

public class InvalidPhoneNoException extends Exception{
    @Override
    public String toString() {
        return "Phone No not valid";
    }
}
