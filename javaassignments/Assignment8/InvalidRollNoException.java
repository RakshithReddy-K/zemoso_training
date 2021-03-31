package javaassignments;

public class InvalidRollNoException extends Exception{
    @Override
    public String toString() {
        return "Invalid RollNo.exceeds limit";
    }
}
