package javaassignments;

public class ExceptionExample {
    public static void exceptionHandling(String name,String phNo,int rolllNo) throws InvalidNameException,InvalidPhoneNoException,InvalidRollNoException
    {
        if(name.length()==0)
            throw new InvalidNameException();
        if(phNo.length()!=10)
            throw new InvalidPhoneNoException();
        if(rolllNo>100)
            throw new InvalidRollNoException();

    }
    public static void main(String[] args) {
        try {
            exceptionHandling("", "000000", 200);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        finally {
            System.out.println("In finally block");
        }
    }
}
