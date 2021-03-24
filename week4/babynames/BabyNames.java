package babynames;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
public class BabyNames {


    public void totalBirths(FileResource fileResource) {
        int maleBirths = 0;
        int femaleBirths = 0;
        int maleNames = 0;
        int femaleNames = 0;
        for (CSVRecord record : fileResource.getCSVParser(false)) {

            int numBorn = Integer.parseInt(record.get(2));
            if (record.get(1).equals("M")) {
                maleBirths += numBorn;
                maleNames++;
            } else if (record.get(1).equals("F")) {
                femaleBirths += numBorn;
                femaleNames++;
            }
        }
        System.out.println("Total Births = " + femaleBirths + maleBirths);
        System.out.println("Female Births = " + femaleBirths);
        System.out.println("Male Births = " + maleBirths);
        System.out.println("Total Names = " + femaleNames + maleNames);
        System.out.println("Female Names = " + femaleNames);
        System.out.println("Male Names = " + maleNames);

    }


    public int getRank(FileResource fileResource, String name, String gender) {

        //System.out.println("Rank of name = "+name+"gender ="+ gender+" in file "+fileName+" is: ");
        int rank = -1;
        int countGenderRank = 0;
        for (CSVRecord record : fileResource.getCSVParser(false)) {

            if (record.get(1).equals(gender)) {
                countGenderRank++;
                if (record.get(0).equals(name)) {
                    rank = countGenderRank;
                    return rank;
                }
            }
        }
        return rank;
    }

    public String getName(FileResource fileResource, int rank, String gender) {

        int countGenderRank = 0;

        for (CSVRecord record : fileResource.getCSVParser(false)) {

            if (record.get(1).equals(gender)) {
                countGenderRank++;
                if (rank == countGenderRank) {
                    return record.get(0);
                }
            }
        }
        return "No NAME";
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {

        FileResource fr_year = new FileResource();
        int rank = getRank(fr_year, name, gender);
        FileResource fr_newYear = new FileResource();
        String newName = getName(fr_newYear, rank, gender);
        System.out.println(name + "born in " + year + " would be " + newName + " if she was born in " + newYear);

    }

    public double getAverageRank(String name, String gender) {

        double sumRank = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            double rank = getRank(fileResource, name, gender);
            if (rank == -1) {
                return -1.0;
            }
            sumRank += rank;
            count++;
        }
        return sumRank / count;
    }

    public String extractNumbers(String text) {

        text = text.replaceAll("[^\\d]", "");
        return text;
    }

    public int yearOfHighestRank(String name, String gender) {

        int result = -1;
        int year = 0;
        int rank = -1;
        int max = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            String fileName = file.getName();
            year = Integer.parseInt(extractNumbers(fileName));
            FileResource fileResource = new FileResource(file);
            rank = getRank(fileResource, name, gender);
            if (rank == -1) {
                return -1;
            }

            if (rank < max) {
                max = rank;
                result = year;
            }

        }
        return result;

    }

    public int getBirthByName(CSVParser parser, String name, String gender) {

        for (CSVRecord record : parser) {
            if (record.get(0).equals(name)) {
                if (record.get(1).equals(gender)) {
                    return Integer.parseInt(record.get(2));
                }
            }
        }
        return -1;
    }

    public int getTotalBirthsRankedHigher(String name, String gender){


        int result = 0;
        FileResource fr = new FileResource();
        int level = getBirthByName(fr.getCSVParser(false),name,gender);
        for(CSVRecord record : fr.getCSVParser(false)){
            int countOtherBirths = 0;
            if(record.get(1).equals(gender) && !record.get(0).equals(name)){
                    countOtherBirths = getBirthByName(fr.getCSVParser(false),record.get(0),gender);
                    if( countOtherBirths >= level)
                        result += countOtherBirths;
            }
        }
        return result;
    }
    public void testTotalBirths(){

        FileResource fileResource = new FileResource();
        totalBirths(fileResource);

    }
    public void testGetRank(){
        FileResource fr = new FileResource();
        System.out.println(getRank(fr,"Mason","M"));
    }
    public void testGetName(){
        FileResource fr = new FileResource();
        System.out.println(getName(fr,2,"M"));
    }
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella",2012,2014,"F");
    }
    public void testGetAverageRank(){
        System.out.println(getAverageRank("Jacob","M"));
    }

    public void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mason","M"));
    }
    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher("Ethan","M"));
    }


}
