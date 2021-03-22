package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
	// write your code here

        Travels ref=new UberSedan("C","TS3456");
        UberCars car=new UberCars("A","TS1234");//Car details
        UberBikes bike=new UberBikes("B","TS2345");//Bike details
        float distanceTravelled;
        System.out.println("Please enter your destination (in km)");
        Scanner s=new Scanner(System.in);
        distanceTravelled=s.nextFloat();
        //Polymorphism
        UberCars k=new UberBikes();
        System.out.println("Expected cost for the ride in a Uber Car is Rs. "+car.rideCost(distanceTravelled));
        System.out.println("Expected cost for the ride in a Uber Bike is Rs. "+bike.rideCost(distanceTravelled));
        System.out.println("Expected cost for the ride in a Uber Sedan is Rs. "+ref.rideCost(distanceTravelled));
        System.out.println("Select the mode of transport : 1.Car 2.Bike 3.Sedan");
        int chosen=s.nextInt();
        System.out.println("Your Ride Details");

        if(chosen==1)
            car.bookCabService();
        else if(chosen==2)
            bike.bookCabService();
        else if(chosen==3)
            ref.bookCabService();
    }

}
