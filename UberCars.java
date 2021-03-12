package com.company;

public class UberCars implements Travels{
    String vehicle_number;
    String driver_name;
    private int base_price;
    private float rate_per_km;
    private final int seating_capacity=4;
    UberCars()
    {
        base_price=45;
        rate_per_km = 9;
    }
    UberCars(String driver_name, String vehicle_number)
    {
        this.vehicle_number=vehicle_number;
        this.driver_name=driver_name;
        base_price=45;
        rate_per_km = 9;
    }

    @Override
    public float costofride(float distance_travelled) {
        return base_price+rate_per_km*distance_travelled;
    }

    @Override
    public void viewdetails() {
    System.out.println("Driver Name :"+driver_name +"\nVehicle Number :"+vehicle_number);
    }
}
