package week2;

import java.util.*;
import edu.duke.*;

public class CharactersInPlay {

    private ArrayList<String> characters;
    private ArrayList<Integer> frequency;
    public CharactersInPlay()
    {
        characters=new ArrayList<String>();
        frequency=new ArrayList<Integer>();
    }
    public void update(String person)
    {
        int index=characters.indexOf(person);
        if(index==-1) {
            characters.add(person);
            frequency.add(1);
        }
        else
        {
            int freq= frequency.get(index);
            frequency.set(index,freq+1);
        }
    }

    public void findALlCharacters()
    {
        FileResource resource=new FileResource();
        characters.clear();
        frequency.clear();
        for(String line : resource.lines())
        {
            StringTokenizer character=new StringTokenizer(line,".");
            if(character.hasMoreTokens()) {
                String token = character.nextToken();
                if (token.length() < line.length())
                    update(token);
            }
        }
    }
        public void printAll()
        {

            for(int index=0;index<characters.size();index++)
            {
                    System.out.println(characters.get(index)+" "+frequency.get(index));
            }
            System.out.println("Most frequent character with most dialogues is "+characters.get(indexOfMax(frequency))+"and the frquency is "+frequency.get(indexOfMax(frequency)));

        }
    public void tester()
    {
        findALlCharacters();
       // printAll();

        charactersWithNumParts(10,15);


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

    public void charactersWithNumParts(int num1,int num2)
    {

        for(int index=0;index<characters.size();index++)
        {
            if(frequency.get(index)>=num1 && frequency.get(index)<=num2)
                System.out.println(characters.get(index)+" "+frequency.get(index));
        }

    }
}
