package com.company;

public class UberBikes extends UberCars{
    private int base_price=20;
    private float rate_per_km=5;
    private final int seating_capacity=1;
    UberBikes()
    {}
    UberBikes(String driver_name, String vehicle_number)
    {
        this.vehicle_number=vehicle_number;
        this.driver_name=driver_name;
    }
    public float rideCost(float distance_travelled) {
        return base_price+rate_per_km*distance_travelled;
    }


}
