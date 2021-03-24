package stringsfirstassignment;

import java.util.ArrayList;

import static java.lang.Character.isLowerCase;

public class MultipleGenes {
    public String findStopCoden(String d, int startindex, String stopcoden) {
        String dna = d.substring(startindex);
        dna = dna.toUpperCase();
        int index = dna.indexOf("ATG");
        int taaindex = -1;
        String ans = "";
        if (index >= 0) {
            if (index + 3 < dna.length()) {
                taaindex = dna.indexOf(stopcoden, index + 3);
                if (taaindex != -1) {
                    ans = dna.substring(index, taaindex + 3);
                    if (ans.length() % 3 != 0)
                        ans = "";

                }


            }
        }
        char ch = d.charAt(0);
        if (isLowerCase(ch) == true)
            return ans.toLowerCase();
        else
            return ans;
    }
    public int findStopCodenIndex(String d, int startindex, String stopcoden) {
        String dna = d.substring(startindex);
        dna = dna.toUpperCase();
        int index = dna.indexOf("ATG");
        int taaindex = -1;
        int ans = -1;
        if (index >= 0) {
            if (index + 3 < dna.length()) {
                taaindex = dna.indexOf(stopcoden, index + 3);
                if (taaindex != -1 && (taaindex - index) % 3 == 0) {
                    ans = taaindex + 3;

                }


            }
        }
        return ans;
    }

    public int startIndex(String dna) {
        int index = dna.indexOf("ATG");
        return index;
    }

    public String findGene(String dna) {
        int start = startIndex(dna);
        if (start != -1)
            return findStopCoden(dna, start, "TAA");
        return "";
    }

    public void testFindGene() {
        ArrayList<String> dnas = new ArrayList<String>();
        dnas.add("ATTAAATHTY");//returns empty ""
        dnas.add("ABCDEFGHIJK");//return ""
        dnas.add("TAATGYUIOTAA");//return ""
        dnas.add("ATGYYYUUU");//return ""
        dnas.add("ATGRETRTYTAA");//return ATGRETRTYTAA
        dnas.add("gatgctataat");//return atgctataa
        for (String dna : dnas) {
            System.out.println(findGene(dna));
        }
    }
    public int howMany(String stringa,String stringb)
    {
        int count=0;
        int firstIndex=stringb.indexOf(stringa);
        int secondIndex=-1;
        while(firstIndex!=-1)
        {
            secondIndex=stringb.indexOf(stringa,firstIndex+stringa.length());
            firstIndex=secondIndex;
            count++;
        }
        return count;
    }

    public void testHowMany()
    {
        System.out.println(howMany("AA","AAYAAAA"));
    }
    public int countGenes(String dna)
    {
        int count=0;
        int start=0;
        while(start!=-1 && start<dna.length() && startIndex(dna.substring(start))>=0)
        {
            start=findStopCodenIndex(dna,startIndex(dna.substring(start)),"TAA");
            if(start!=-1)
                count++;
        }
        return count;
    }
}
