package stringsfirstassignment;

import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Character.*;

public class Part2 {
    public String simpleGene(String d,int startcoden,int stopcoden)
    {
        String dna=d.substring(startcoden,stopcoden);
        dna=dna.toUpperCase();
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
        char ch=d.charAt(0);
        if(isLowerCase(ch)==true)
            return ans.toLowerCase();
        else
            return ans;
    }



    public void testSimpleGene()
    {
        ArrayList<String> dnas=new ArrayList<String>();
        dnas.add("ATTAAATHTY");//returns empty ""
        dnas.add("ABCDEFGHIJK");//return ""
        dnas.add("TAATGYUIOTAA");//return ""
        dnas.add("ATGYYYUUU");//return ""
        dnas.add("ATGRETRTYTAA");//return ATGRETRTYTAA
        dnas.add("gatgctataat");//return atgctataa
        for(String dna :dnas)
        {
            System.out.println(simpleGene(dna,0,dna.length()));
        }


    }
}
