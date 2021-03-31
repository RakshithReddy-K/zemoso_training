package edu;

import edu.duke.*;
import java.io.File;
import java.util.ArrayList;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
       int count=0;
       for(Point newPoint : s.getPoints())
       {
           count=count+1;
       }
       return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here

        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxDist=0.0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist>maxDist)
                maxDist=currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return maxDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double maxX=0.0;

        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find X of curr Point
            double currX = currPt.getX();
            // Update maxX
            if(currX>maxX)
                maxX=currX;
            // Update prevPt to be currPt

        }
        return maxX;


    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource newDirectory=new DirectoryResource();
        Iterable<File> files=newDirectory.selectedFiles();
        double maxPerimeter=0.0;
        for(File newFile : files)
        {
            FileResource fr = new FileResource(newFile);
            Shape s=new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(currPerimeter>maxPerimeter)
                maxPerimeter=currPerimeter;
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        DirectoryResource newDirectory=new DirectoryResource();
        Iterable<File> files=newDirectory.selectedFiles();
        double maxPerimeter=0.0;
        for(File newFile : files)
        {
            FileResource fr = new FileResource(newFile);
            Shape s=new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(currPerimeter>maxPerimeter) {
                maxPerimeter = currPerimeter;
                temp=newFile;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points are "+getNumPoints(s));
        System.out.println("Average side length is "+getAverageLength(s));
        System.out.println("Largest side length is "+getLargestSide(s));
        System.out.println("Maximum X value of all points is "+getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest perimeter in multiple files is "+getLargestPerimeterMultipleFiles());

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File name containing Largest perimeter in multiple files is "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
