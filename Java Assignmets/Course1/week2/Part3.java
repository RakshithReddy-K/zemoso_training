package stringsfirstassignment;

import java.util.*;

public class Part3 {
    public boolean twoOccurences(String stringa,String stringb)
    {
        int firstIndex=stringb.indexOf(stringa);
        int secondIndex=-1;
        if(firstIndex!=-1)
        {
            secondIndex=stringb.indexOf(stringa,firstIndex+stringa.length());
            if(secondIndex!=-1)
            {
                return true;
            }
        }
        return false;
    }
    public String lastPart(String stringa,String stringb)
    {
        int firstIndex=stringb.indexOf(stringa);
        if(firstIndex!=-1)
        {
            return stringb.substring(firstIndex+stringa.length());
        }
        return stringb;
    }
    public void testing()
    {
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
        System.out.println(twoOccurences("an","banana"));
        System.out.println(twoOccurences("atg","atgtaaaytatg"));
        System.out.println(twoOccurences("atg","atgtaaayt"));


    }
}
