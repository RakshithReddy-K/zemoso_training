package com.company;

public class TravelAgent implements Travels{
    Travels reference;
    public TravelAgent(Travels reference)
    {
        this.reference=reference;
    }

    @Override
    public float rideCost(float distance) {
        return reference.rideCost(distance);
    }

    @Override
    public void viewDetails() {
        reference.viewDetails();
    }

    @Override
    public void bookCabService() {
        reference.bookCabService();
    }
}
