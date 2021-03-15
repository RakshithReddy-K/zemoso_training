package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
	// write your code here
        Travels t=new UberCars();
        UberCars car=new UberCars("A","TS1234");
        UberBikes bike=new UberBikes("B","TS2345");
        float distance;
        System.out.println("Please enter your destination (in km)");
        Scanner s=new Scanner(System.in);
        distance=s.nextFloat();
        //Polymorphism
        UberCars k=new UberBikes();
        System.out.println("Expected cost for the ride in a Uber Car is Rs. "+car.rideCost(distance));
        System.out.println("Expected cost for the ride in a Uber Bike is Rs. "+bike.rideCost(distance));
        System.out.println("Cost(found using superclass reference): "+k.rideCost(distance));
        System.out.println("Select the mode of transport : 1.Car 2.Bike");
        int chosen=s.nextInt();
        System.out.println("Your Ride Details");

        if(chosen==1)
            car.viewDetails();
        else if(chosen==2)
            bike.viewDetails();
    }
}
