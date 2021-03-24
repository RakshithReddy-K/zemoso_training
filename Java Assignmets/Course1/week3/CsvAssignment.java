package csvassg;

import edu.duke.*;
import org.apache.commons.csv.*;

public class CsvAssignment {
    public void countryInfo(CSVParser parser,String country)

    {
        boolean found=false;
        for(CSVRecord record : parser)
        {
            if(record.get("Country").equalsIgnoreCase(country))
            {
                System.out.println(country +": "+record.get("Exports") +": "+record.get("Value (dollars)"));
                found=true;
                break;
            }

        }
        if(found==false)
            System.out.println("NOT FOUND");

    }
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for(CSVRecord record :parser)
        {
            String exports=record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    public int numberOfExporters(CSVParser parser,String exportItem)
    {
        int count=0;
        for(CSVRecord record :parser)
        {
            String exports=record.get("Exports");
            if(exports.contains(exportItem) )
            {
                count++;
            }
        }
    return count;
    }

    public void bigExporters(CSVParser parser,String amount)
    {
        for(CSVRecord record :parser)
        {
            String value=record.get("Value (dollars)");
            if(value.length()>amount.length())
            {
                System.out.println(record.get("Country") +" "+value);
            }
        }

    }
    public void tester()
    {
        FileResource file=new FileResource();
        CSVParser parser=file.getCSVParser();
        //countryInfo(parser,"Germany");
        //parser=file.getCSVParser();
        //listExportersTwoProducts(parser,"gold","diamonds");
        //parser=file.getCSVParser();
        //System.out.println(numberOfExporters(parser,"gold"));
        //parser=file.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
        //System.out.println(numberOfExporters(parser,"sugar"));
        //countryInfo(parser,"Nauru");
    }


}
