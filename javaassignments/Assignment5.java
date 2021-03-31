package javaassignments;

public class Assignment5 {
    int uninitializedInt;
    char uninitializedChar;
    String string;
    public void printClassVariables()
    {
        System.out.println(uninitializedInt);
        System.out.println(uninitializedChar);

    }
    public void printLocalVariables()
    {
        int localInt;
        int localChar;
       // System.out.println(localChar);
       // System.out.println(localInt);
        //Cannot print without initializing

    }
    public static Assignment5 stringMethod(String input)
    {
        //string=input;
        //Cannot access non static variables from static methods
        return new Assignment5();
    }

}
