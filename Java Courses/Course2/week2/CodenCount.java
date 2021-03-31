package week2;

import java.util.*;

public class CodenCount {
    private HashMap<String,Integer> codenMap;
    public CodenCount()
    {
        codenMap=new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna)
    {
        codenMap.clear();
        dna=dna.trim();
        for(int index=start;index<dna.length() && index+3<=dna.length();index+=3)
        {
            String coden=dna.substring(index,index+3);
            coden=coden.toUpperCase();
            if(codenMap.keySet().contains(coden))
                codenMap.put(coden,codenMap.get(coden)+1);
            else
                codenMap.put(coden,1);
        }
    }

    public String getMostCommonCodon()
    {
        int max=-1;
        String common=null;
        for(String coden: codenMap.keySet())
        {
            coden=coden.toUpperCase();
            if(codenMap.get(coden)>max)
            {
                max=codenMap.get(coden);
                common=coden;
            }
        }
        return common;
    }

    public void printCodenCounts(int start,int end)
    {
           System.out.println("Counts of codons between "+ start+" and "+end +" inclusive are:");
        for(String coden: codenMap.keySet())
        {
            coden=coden.toUpperCase();
            if(codenMap.get(coden)>=start && codenMap.get(coden)<=end)
            {
                System.out.println(coden+"  "+ codenMap.get(coden));
            }
        }

    }

    public void tester()
    {
        for(int start=0;start<3;start++)
        {
            codenMap.clear();
            buildCodonMap(start,"CGTTCAAGTTCAA");
            String commonCoden=getMostCommonCodon();
            System.out.println("Reading frame starting with "+start+" results in "+codenMap.size()+" unique codons\n" +
                    "\n" +
                    "  and most common codon is "+commonCoden+" with count "+ codenMap.get(commonCoden));
            printCodenCounts(1,5);
        }
    }

}
