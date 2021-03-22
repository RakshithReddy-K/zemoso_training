package com.company;

public class UberSedan extends UberCars {

    private final int seatingCapacity=6;
    UberSedan(String driverName, String vehicleNumber)
    {
        super(driverName,vehicleNumber);
    }
    public float rideCost(float distanceTravelled)
    {
        float cost=super.rideCost(distanceTravelled);
        return (cost*seatingCapacity)/4;
    }
}
