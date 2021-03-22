package com.company;

public class UberCars implements Travels{
    String vehicleNumber;
    String driverName;
    private final int basePrice=45;
    private final float ratePerKm=9;
    private final int seatingCapacity=4;
    UberCars()
    { }
    UberCars(String driverName, String vehicleNumber)
    {
        this.vehicleNumber=vehicleNumber;
        this.driverName=driverName;

    }
    public int getBasePrice()
    {
        return basePrice;
    }
    public float getRatePerKm()
    {
        return ratePerKm;
    }

    @Override
    public float rideCost(float distanceTravelled) {
        return basePrice+ratePerKm*distanceTravelled;
    }

    @Override
    public void viewDetails() {
    System.out.println("Driver Name :"+driverName +"\nVehicle Number :"+vehicleNumber );
    }

    @Override
    public void bookCabService() {
        System.out.println("Cab booked . Below are your ride Details");
        viewDetails();
    }
}
