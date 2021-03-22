package com.company;

import java.util.Random;

public class OlaCabs implements Travels,TravelsOtp{

    private int otp;
    String vehicleNumber;
    String driverName;
    private final int basePrice=57;
    private final float ratePerKm=10;
    private final int seatingCapacity=4;

    public OlaCabs(String driverName, String vehicleNumber)
    {
        this.vehicleNumber=vehicleNumber;
        this.driverName=driverName;
    }
    public int generateOtp() {
        Random generator=new Random();
        otp=generator.nextInt(10000);
        return otp;
    }

    @Override
    public void validateOtp(int otp) {
        if(this.otp==otp)
            System.out.println("Otp Valid ....Starting Ride");
        else
            System.out.println("Otp Invalid ....");


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
