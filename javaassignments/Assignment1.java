package javaassignments;
import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Assignment1 {

    private static File homeDirectory=new File("/home/raksr/Downloads");


    public static void checkMatchingFiles()
    {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the expression you wish to match OR Enter q to exit");
            String input = scanner.nextLine();
            if(input.equals("q"))
                return;
            Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);//Creating pattern with given input
            printAbsolutePath(homeDirectory, pattern);
        }
    }
    public static void printAbsolutePath(File homeDirectory,Pattern pattern){
        File[] allFiles = homeDirectory.listFiles();
        for (File file : allFiles) {
            if (file.isDirectory())
                printAbsolutePath(file,pattern);//recursive call to open directories
            else {
                Matcher matcher = pattern.matcher(file.getName());
                if(matcher.find())
                    System.out.println(file.getAbsolutePath());//print absolute path
            }
        }
    }
    public static void main(String[] args)
    {
            checkMatchingFiles();
    }
}
