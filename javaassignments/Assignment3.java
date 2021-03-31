package javaassignments;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Assignment3 {
    public static void pingCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";

            while ((s = inputStream.readLine()) != null) {
                int index=s.indexOf("time=");
                String time="";
                if(index!=-1)
                    time=s.substring(index+5,index+11);
               // System.out.println(s);
                System.out.println(time);

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        String ip;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ip address : ");
        ip =in.nextLine();
        pingCommand("ping -c 4 " + ip);


    }
}
