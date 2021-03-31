package javaassignments.Assignment7;

public class Hamster extends Rodent{

    Hamster(){
        System.out.println("Inside Hamster class");
    }

    @Override
    void checkCheekPouch() {
        System.out.println("Hamsters have cheek pouches");
    }

    @Override
    void lifeSpan() {
        System.out.println("Mouse life span = 3-4 years");
    }
}
