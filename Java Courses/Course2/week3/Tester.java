
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package week3;
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer analyser=new LogAnalyzer();
        analyser.readFile();
        System.out.println("Number of unique IP addresses are :"+analyser.countUniqueIp());
        System.out.println("log Records having status code greater than 400 are ");
        analyser.printAllHigherThanNum(400);
        System.out.println("Number of unique IPS on Sep 30 are "+analyser.uniqueIPVisitsOnDay("Mar 17"));
        System.out.println(analyser.countUniqueIPsInRange(200,299));
    }


}
