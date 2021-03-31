package week2;
import edu.duke.*;

import java.io.*;
import java.security.DigestException;
import java.util.*;

public class WordsInFile {
    private HashMap<String, ArrayList<String>> wordsMap=new HashMap<String, ArrayList<String>>();
    public void addWordsFromFile(FileResource file,String filename)
    {
        for(String word:file.words()) {
            ArrayList<String> files=new ArrayList<String>();

            if (wordsMap.containsKey(word)) {
                if (!wordsMap.get(word).contains(filename)) {
                    files=wordsMap.get(word);
                    files.add(filename);

                }
            }
            else
                files.add(filename);

            wordsMap.put(word,files);


        }
    }

    public void buildWordFileMap()
    {
        DirectoryResource dir =new DirectoryResource();
        Iterable<File> files=dir.selectedFiles();
        for(File newFile : files)
        {
            FileResource fr=new FileResource(newFile);
            addWordsFromFile(fr,newFile.getName());
        }
    }

        public int maxNumber()
        {
            int max=-1;
            for(String word : wordsMap.keySet())
            {
                int numberOfFiles=wordsMap.get(word).size();
                if(max<numberOfFiles)
                {
                    max=numberOfFiles;
                }
            }
            return max;
        }

        public ArrayList<String> wordsInNumFiles(int freq)
        {
            ArrayList<String> words=new ArrayList<String>();
            for(String word : wordsMap.keySet())
            {
                int numberOfFiles=wordsMap.get(word).size();
                if(numberOfFiles==freq)
                {
                    words.add(word);
                }
            }
            return words;
        }

        public void printFilesIn(String word)
        {
            ArrayList<String> files=new ArrayList<String>();
            files=wordsMap.get(word);
            for(String file : files)
            {
                System.out.print(file+" ");
            }
        }

        public void tester()
        {
            buildWordFileMap();
            System.out.println(maxNumber());
            printFilesIn("cats");
            ArrayList<String> freqWords=new ArrayList<String>();
            freqWords=wordsInNumFiles(3);
            for(String word:freqWords)
            {
                System.out.print(word+" ");
            }

        }
}
