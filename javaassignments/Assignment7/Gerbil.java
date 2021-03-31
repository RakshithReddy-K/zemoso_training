package javaassignments.Assignment7;

public class Gerbil extends Rodent{

    Gerbil(){
        System.out.println("Inside Gerbil class");
    }

    @Override
    void lifeSpan() {
        System.out.println("Gerbil life span = 2-3 years");
    }

    void gerbilTail(){
        System.out.println("Gerbil has a long tail");
    }
}
