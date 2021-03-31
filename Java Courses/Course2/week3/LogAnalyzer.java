
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package week3;
import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records=new ArrayList<LogEntry>();
     }
        
     public void readFile() {
         FileResource fr =new FileResource();
         for(String line : fr.lines())
         {
             LogEntry newLog=WebLogParser.parseEntry(line);
             records.add(newLog);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }


     }

     public  int countUniqueIp()
    {
        ArrayList<String> uniqueIps=new ArrayList<String>();
        for(LogEntry log : records)
        {
            String ipaddr=log.getIpAddress();
            if(!uniqueIps.contains(ipaddr))
            {
                uniqueIps.add(ipaddr);
            }
        }
        return uniqueIps.size();
    }

    public void printAllHigherThanNum(int num)
    {
        int count=0;
        for(LogEntry log : records)
        {
            if(log.getStatusCode()>num)
                System.out.println(log.toString());
        }

    }
    public int countUniqueIPsInRange(int low,int high)
    {
        ArrayList<String> uniqueIps=new ArrayList<String>();
        for(LogEntry log : records)
        {
            String ipaddr=log.getIpAddress();
            int statusCode=log.getStatusCode();
            if(statusCode>=low && statusCode<=high && !uniqueIps.contains(ipaddr))
            {
                uniqueIps.add(ipaddr);
            }
        }
        return uniqueIps.size();
    }
    public int uniqueIPVisitsOnDay(String someday)
    {
        ArrayList<String> uniqueIps=new ArrayList<String>();
        for(LogEntry log : records)
        {
            String ipaddr=log.getIpAddress();
            Date d=log.getAccessTime();
            String date=d.toString().substring(4,10);

            if(date.equals(someday) && !uniqueIps.contains(ipaddr))
            {
                uniqueIps.add(ipaddr);
            }
        }
        return uniqueIps.size();
    }
    }
