
package csvassg;
import edu.duke.*;
import org.apache.commons.csv.*;


public class Main {
    public static void main(String[] args)
    {
        //CsvAssignment c=new CsvAssignment();
        //c.tester();
        WeatherAssignment w=new WeatherAssignment();
        //w.testColdestHourInFile();
        //w.testFileWithColdestTemp();
        w.testLowestHumidityInFile();
        //w.testLowestHumidityInManyFiles();
       // w.testAverageTemperatureInFile();
       // w.testAverageTemperatureWithHighHumidityInFile();
    }
}
