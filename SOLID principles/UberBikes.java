package com.company;

public class UberBikes extends UberCars{
    private final int basePrice=20;
    private final float ratePerKm=5;
    private final int seatingCapacity=1;
    UberBikes()
    {}
    UberBikes(String driverName, String vehicleNumber)
    {
       super(driverName,vehicleNumber);
    }
    public float rideCost(float distanceTravelled) {
        return basePrice+ratePerKm*distanceTravelled;
    }


}
