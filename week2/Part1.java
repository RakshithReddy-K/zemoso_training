package stringsfirstassignment;

import java.util.ArrayList;

public class Part1 {
    public String simpleGene(String dna)
    {
        int index=dna.indexOf("ATG");
        int taaindex=-1;
        String ans="";
        if(index>=0) {
            if (index + 3 < dna.length()) {
                taaindex = dna.indexOf("TAA", index + 3);
                if (taaindex != -1) {
                    ans= dna.substring(index, taaindex+3);
                    if(ans.length()%3!=0)
                        ans="";

                }


            }
        }

        return ans;
    }
    public void testSimpleGene()
    {
        ArrayList<String> dnas=new ArrayList<String>();
        dnas.add("ATTAAATHTY");//returns empty ""
        dnas.add("ABCDEFGHIJK");//return ""
        dnas.add("TAATGYUIOTAA");//return ""
        dnas.add("ATGYYYUUU");//return ""
        dnas.add("ATGRETRTYTAA");//return RETRTY
        dnas.add("AAATGCCCTAACTAGATTAAGAAACC");
        for(String dna :dnas)
        {
            System.out.println(simpleGene(dna));
        }


    }
}
