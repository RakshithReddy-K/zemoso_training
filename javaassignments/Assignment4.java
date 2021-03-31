package javaassignments;

import java.util.*;

public class Assignment4 {
    public static void main(String[] args)
    {
        Assignment4 kyc=new Assignment4();
        kyc.printKycRange();


    }

    public void printDate(Calendar start,Calendar end)
    {
        System.out.print(start.get(Calendar.DATE)+"-"+start.get(Calendar.MONTH)+"-"+start.get(Calendar.YEAR)+" ");
        System.out.println(end.get(Calendar.DATE)+"-"+end.get(Calendar.MONTH)+"-"+end.get(Calendar.YEAR)+" ");

    }
    public void printKycRange()
    {
        Scanner scanner=new Scanner(System.in);
        int testCases=Integer.parseInt(scanner.nextLine());
        while(testCases>=0)
        {
            String[] dates=scanner.nextLine().split(" ");
            String[] signUp=dates[0].split("-");
            String[] current=dates[1].split("-");
            Calendar signUpDate=Calendar.getInstance();
            Calendar currentDate=Calendar.getInstance();
            signUpDate.set(Integer.parseInt(signUp[2]),Integer.parseInt(signUp[1]),Integer.parseInt(signUp[0]));

            currentDate.set(Integer.parseInt(current[2]),Integer.parseInt(current[1]),Integer.parseInt(current[0]));

            Calendar start=Calendar.getInstance();
            Calendar end=Calendar.getInstance();
            start=(Calendar)signUpDate.clone();
            end=(Calendar)signUpDate.clone();

            start.add(Calendar.DATE,-30);
            end.add(Calendar.DATE,30);
            start.set(Calendar.YEAR,currentDate.get(Calendar.YEAR));
            end.set(Calendar.YEAR,currentDate.get(Calendar.YEAR));
            if(signUpDate.get(Calendar.YEAR)>=currentDate.get(Calendar.YEAR) || start.after(currentDate)) {
                System.out.println("No range");
            }
            else if(end.after(currentDate)) {
                end = currentDate;
                printDate(start,end);
            }
            else
            {
              printDate(start,end);
            }
            testCases--;
        }
    }

}
