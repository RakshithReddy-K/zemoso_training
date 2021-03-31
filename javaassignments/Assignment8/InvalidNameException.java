package javaassignments;

public class InvalidNameException extends Exception{
    @Override
    public String toString() {
        return "Name not valid";
    }
}
