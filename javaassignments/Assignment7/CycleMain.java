package javaassignments.Assignment7;

public class CycleMain {

    public static void main(String[] args){
        Cycle[] cycles = new Cycle[4];
        cycles[0] = new Cycle();
        cycles[1] = new UniCycle();
        cycles[2] = new BiCycle();
        cycles[3] = new TriCycle();



        //cycles[1].balance(); //error->superclass reference referring the subclass object cannot access the subclass's non-overridden methods.
        UniCycle newUniCycle = (UniCycle)(cycles[1]);//Use down casting
        newUniCycle.balance();

        UniCycle uniCycle = new UniCycle();
        uniCycle.balance();

      //  BiCycle newTriCycle = (BiCycle)(cycles[2]);//Since we are using the Cycle reference, we can still call balance() method for TriCycle object.
       // newTriCycle.balance();

//        TriCycle triCycle = new TriCycle();
//        BiCycle triCycleWithBiCycle = (BiCycle)(triCycle); //error -Cannot cast




    }


}
