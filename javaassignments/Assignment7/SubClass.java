package javaassignments.Assignment7;

public class SubClass extends SuperClass implements InterfaceCombined{

    SubClass(){System.out.println("Inside subclass");}
    @Override
    public void newMethod() {
        System.out.println("InterfaceCombined-newMethod");
    }

    @Override
    public void firstMethod() {
        System.out.println("Method 1");
    }

    @Override
    public void secondMethod() {
        System.out.println("Method 2");
    }

    @Override
    public void thirdMethod() {
        System.out.println("Method 3");
    }

    @Override
    public void fourthMethod() {
        System.out.println("Method 4");
    }
    @Override
    public void fifthMethod() {
        System.out.println("Method 5");
    }

    @Override
    public void sixthMethod() {
        System.out.println("Method 6");
    }

    public void interfaceOneMethod(InterfaceOne interfaceOne){
        interfaceOne.firstMethod();
        interfaceOne.secondMethod();
    }
    public void interfaceTwoMethod(InterfaceTwo interfaceTwo){
        interfaceTwo.thirdMethod();
        interfaceTwo.fourthMethod();
    }
    public void interfaceThreeMethod(InterfaceThree interfaceThree){
        interfaceThree.fifthMethod();
        interfaceThree.sixthMethod();
    }
    public void interfaceCombinedMethod(InterfaceCombined interfaceCombined){
        interfaceCombined.newMethod();
    }

}
