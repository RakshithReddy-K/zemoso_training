package Course2;

import edu.duke.*;

import java.util.*;

public class WordLengths {
    public void countWordLengths(FileResource resource,int[] counts)
    {
        int maxLength=counts.length;
        Iterable<String>  words=resource.words();
        for(String word : words)
        {
            int wordLength=word.length();
            if(!Character.isLetter(word.charAt(wordLength-1)))
                wordLength--;

            if(!Character.isLetter(word.charAt(0)))
                wordLength--;

            if(wordLength>=maxLength)
                wordLength=maxLength-1;
            counts[wordLength]++;
        }

    }

    public int indexOfMax(int[] values)
    {
        int maxIndex=0;
        for(int index=1;index<values.length;index++) {
            if (values[maxIndex] < values[index])
                maxIndex=index;
        }
        return maxIndex;
    }

    public void testCountWordLengths()
    {
        FileResource fr =new FileResource();
        int[] counts=new int[31];
        countWordLengths(fr,counts);
        System.out.println(indexOfMax(counts));
    }
}
