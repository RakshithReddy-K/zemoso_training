package csvassg;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.*;

import java.io.File;

public class WeatherAssignment {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldestRecord=null;
        double coldestTemp=10000;
        for(CSVRecord record : parser )
        {
            String t=record.get("TemperatureF");
            double temp=Double.parseDouble(t);
            if(temp!=-9999 && temp<coldestTemp  )
            {
                coldestTemp=temp;
                coldestRecord=record;
            }

        }
        return coldestRecord;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord lowestRecord=null;
        double lowestHumidity=100000;
        for(CSVRecord record : parser )
        {
            String t=record.get("Humidity");
            if(t.equalsIgnoreCase("N/A"))
                continue;
            double humidity=Double.parseDouble(t);
            if( humidity<lowestHumidity )
            {
                lowestHumidity=humidity;
                lowestRecord=record;
            }

        }
        return lowestRecord;
    }

    public String fileWithColdestTemp()
    {
        DirectoryResource dir=new DirectoryResource();
        Iterable<File> files=dir.selectedFiles();
        double lowestTemp=100000;
        File ans=null;
        for(File file : files)
        {
            FileResource fr = new FileResource(file);
            CSVParser parser =fr.getCSVParser();
            CSVRecord record=coldestHourInFile(parser);
            String t=record.get("TemperatureF");
            double temp=Double.parseDouble(t);
            if(temp<lowestTemp)
            {
                lowestTemp=temp;
                ans=file;
            }
        }
        System.out.println("Coldest day was in file"+ans.getName());
        System.out.println("Coldest temperature on that day was "+lowestTemp);
        System.out.println("All the Temperatures on the coldest day were:");
        FileResource fr = new FileResource(ans);
        CSVParser parser =fr.getCSVParser();
        for(CSVRecord record :parser)
        {
            System.out.println(record.get("DateUTC")+" "+record.get("TemperatureF"));
        }

        return ans.getName();

    }


    public void lowestHumidityInManyFiles()
    {
        DirectoryResource dir=new DirectoryResource();
        Iterable<File> files=dir.selectedFiles();
        double lowestHumidity=100000;
        File ans=null;
        String date=null;
        for(File file : files)
        {
            FileResource fr = new FileResource(file);
            CSVParser parser =fr.getCSVParser();
            CSVRecord record=lowestHumidityInFile(parser);
            String t=record.get("Humidity");

            double humidity=Double.parseDouble(t);
            if(humidity<lowestHumidity)
            {
                lowestHumidity=humidity;
                ans=file;
                date=record.get("DateUTC");
            }
        }

        System.out.println("Lowest Humidity was "+lowestHumidity+" on "+date);


    }



    public double averageTemperatureInFile(CSVParser parser)
    {
        double total=0.0,average;
        int count=0;
        for(CSVRecord record:parser)
        {
            String t=record.get("TemperatureF");
            double temp=Double.parseDouble(t);
            total=total+temp;
            count++;

        }
        average=total/count;
        return average;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,double value)
    {
        double total=0.0,average=0.0;
        int count=0;
        for(CSVRecord record:parser)
        {
            String t=record.get("TemperatureF");
            double temp=Double.parseDouble(t);
            String t1=record.get("Humidity");

            double humidity=Double.parseDouble(t1);
            if(humidity>=value) {
                total = total + temp;
                count++;
            }
        }
        if(count!=0)
            average=total/count;
        return average;
    }


    public void testColdestHourInFile()
    {
        FileResource file=new FileResource();
        CSVParser parser=file.getCSVParser();
        CSVRecord coldest=coldestHourInFile(parser);
        System.out.println("Time of occurance is :"+coldest.get("DateUTC"));
    }
    public void testFileWithColdestTemp()
    {
        String s=fileWithColdestTemp();
    }
    public void testLowestHumidityInFile()
    {
        FileResource file=new FileResource();
        CSVParser parser=file.getCSVParser();
        CSVRecord lowest=lowestHumidityInFile(parser);
        System.out.println("Time of occurance is :"+lowest.get("DateUTC"));
    }
    public void testLowestHumidityInManyFiles()
    {
        lowestHumidityInManyFiles();
    }

    public void testAverageTemperatureInFile()
    {
        FileResource file=new FileResource();
        CSVParser parser=file.getCSVParser();
        System.out.println("Average temperature in file is "+averageTemperatureInFile(parser));
    }

    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource file=new FileResource();
        CSVParser parser=file.getCSVParser();
        double averageTemp=averageTemperatureWithHighHumidityInFile(parser,80);
        if(averageTemp==0)
        {
            System.out.println("No temperatures with that humidity");
        }
        else
        System.out.println("Average temperature in file is "+averageTemp);
    }
}
