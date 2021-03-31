package javaassignments;


import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
    public static boolean checkAllAlphabets(String text)
    {
        int length=text.length();
       if(length>=26)
       {

           int[] count=new int[26];
           int unique=0;
           for(int index=0;index<length && unique<26;index++) {
               int ch = Character.toLowerCase(text.charAt(index));
               if (ch >= 'a' && ch <= 'z') {
                   if (count[ch - 'a'] == 0)
                       unique++;
                   count[ch - 'a']++;
               }
           }
           if(unique==26)
               return true;
           else
               return false;
       }
       return false;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text ");
        String input = scanner.nextLine();
        checkAllAlphabets(input);
    }
    //Time Complexity : O(n)
    // Space Complexity : O(1)
}
