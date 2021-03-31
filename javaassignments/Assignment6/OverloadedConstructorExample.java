package javaassignments;

public class OverloadedConstructorExample {
    String name;
    int rollNo;
    public OverloadedConstructorExample(String name)
    {
        this.name=name;
        System.out.println(this.name);
    }
    public OverloadedConstructorExample(int rollNo)
    {
        this("Arnold");
        this.rollNo=rollNo;
    }

    public static void main(String[] args)
    {
        OverloadedConstructorExample example=new OverloadedConstructorExample(45);
      //  System.out.println(example.name);
       // System.out.println(example.rollNo);
        OverloadedConstructorExample[] array=new OverloadedConstructorExample[3];
        array[0]=new OverloadedConstructorExample("Rakshith");

    }
}
