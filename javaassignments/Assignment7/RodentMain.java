package javaassignments.Assignment7;

public class RodentMain {

    public static void main(String[] args){

        Rodent[] rodent = new Rodent[3];

        rodent[0] = new Mouse();//upcasting (child object to parent)
        rodent[0].lifeSpan();
        rodent[0].checkCheekPouch();//no checkCheekPouch() in Mouse class, Rodent class's method is accessed

        System.out.println("\n");

        rodent[1] = new Gerbil();
        rodent[1].lifeSpan();
        rodent[1].checkCheekPouch();//no checkCheekPouch() in Gerbil class, Rodent class's method is accessed
        //rodent[1].gerbilTail(); error because a super class cannot invoke a subclass method(if not overridden). use down casting.

        Gerbil gerbilDownCast = (Gerbil)rodent[1];
        gerbilDownCast.gerbilTail();

        System.out.println("\n");


        rodent[2] = new Hamster();
        rodent[2].lifeSpan();
        rodent[2].checkCheekPouch();//run time polymorphism

        System.out.println("\n");


        Gerbil gerbil = new Gerbil();
        gerbil.lifeSpan();
        gerbil.checkCheekPouch(); //A subclass can access any method of superclass, not just the overridden one.
        gerbil.gerbilTail();

    }
}
