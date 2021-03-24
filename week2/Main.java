package stringsfirstassignment;

public class Main {
    public static void main(String[] args)
    {
        Part1 dnaExample=new Part1();
        dnaExample.testSimpleGene();
        Part2 dnaExample2=new Part2();
        dnaExample2.testSimpleGene();
        Part3 dnaExample3=new Part3();
        dnaExample3.testing();
        WebLinks w=new WebLinks();
        w.search();
        MultipleGenes m=new MultipleGenes();
        m.testHowMany();
        System.out.println(m.countGenes("ATGTAAGATGCCCTAAT"));

    }
}
