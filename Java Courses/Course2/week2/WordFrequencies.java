package week2;

import edu.duke.*;

import java.util.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public  WordFrequencies()
    {
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }

    public void findUnique()
    {
        FileResource resource=new FileResource();
        myFreqs.clear();
        myWords.clear();
        for(String word:resource.words())
        {
            word=word.toLowerCase();
            int index= myWords.indexOf(word);
            if(index==-1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int prevValue=myFreqs.get(index);
                myFreqs.set(index,prevValue+1);
            }

        }
    }

    public int indexOfMax(ArrayList<Integer> values)
    {
        int maxIndex=0;
        for(int index=1;index<values.size();index++) {
            if (values.get(maxIndex) < values.get(index))
                maxIndex=index;
        }
        return maxIndex;
    }


    public void tester()
    {
        findUnique();
        System.out.println("Number of Unique words are :"+myWords.size());
        for(int index=0;index<myWords.size();index++)
        {
            System.out.println(myWords.get(index)+" "+myFreqs.get(index));
        }
        int maxIndex=indexOfMax(myFreqs);
        System.out.println("The word that occurs most often and its count are: "+ myWords.get(maxIndex)+" "+myFreqs.get(maxIndex));
    }
}
