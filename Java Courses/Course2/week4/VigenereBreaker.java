package Course2;

import edu.duke.*;

import java.util.HashSet;

public class VigenereBreaker {


    public HashSet<String> readDictionary(){
        System.out.println("Choose a Dictionary File - ");
        FileResource fileResource = new FileResource();
        HashSet<String> dictionary = new HashSet<>();
        for(String words : fileResource.lines()){
            words = words.toLowerCase();
            dictionary.add(words);
        }
        return dictionary;
    }
    public int countWords(String message, HashSet<String> dictionary){

        int wordCount= 0;
        String[] words = message.split("\\W+");
        for(String word:words){
            word = word.toLowerCase();
            if(dictionary.contains(word)) wordCount++;
        }
        return wordCount;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){

        String decryptionString = null;
        int maxCount = -1;
        for(int kLength=1;kLength<=100;kLength++){
            int[] keys = tryKeyLength(encrypted,kLength);
            VigenereCipher vigenereCipher = new VigenereCipher(keys);
            String decrypted = vigenereCipher.decrypt(encrypted);
            int currentWords = countWords(decrypted,dictionary);
            if(currentWords > maxCount){
                maxCount = currentWords;
                decryptionString = decrypted;
            }
        }
        return decryptionString;
    }
    public String sliceString(String message, int whichSlice, int totalSlices) {

        StringBuilder slicedMessage = new StringBuilder();
        for(int index=whichSlice;index<= message.length() && index+totalSlices <= message.length();index += totalSlices)
            slicedMessage.append(message.charAt(index));

        return slicedMessage.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength) {
        int[] key = new int[klength];
        for(int index=0;index<klength;index++){
            String slicedString = sliceString(encrypted,index,klength);
            CaesarCracker caesarCracker = new CaesarCracker();
            int keyPerSlice = caesarCracker.getKey(slicedString);
            key[index] = keyPerSlice;
        }
        return key;
    }

    public void breakVigenere () {

        FileResource fileResource = new FileResource();
        String encrypted = fileResource.asString();
        HashSet<String> dictionary = readDictionary();
        System.out.println("Decrypted String -> \n" + breakForLanguage(encrypted, dictionary));



        int[] keys = tryKeyLength(encrypted,4);
        VigenereCipher vigenereCipher = new VigenereCipher(keys);
        System.out.println(vigenereCipher.decrypt(encrypted));

    }



//    public String breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
//
//        int countMax = -1;
//        String decryptionString = null;
//        for(String languageName : languages.keySet()) {
//            HashSet<String> dictionary = readDictionary();
//            String decryptionPerLanguage = breakForLanguage(encrypted, dictionary);
//            int currentWords = countWords(decryptionPerLanguage, dictionary);
//            if (currentWords > countMax) {
//                countMax = currentWords;
//                decryptionString = decryptionPerLanguage;
//            }
//        }
//        return decryptionString;
//    }



//    public char mostCommonCharIn(HashSet<String> dictionary){
//        int maxCountIndex = 0;
//        int[] alphabet = new int[26];
//        for(String words : dictionary)
//            for(char letter: words.toCharArray())
//                if(Character.isLetter(letter))
//                    alphabet[(int)letter - 97]++;
//
//        for(int index=1;index<alphabet.length;index++)
//            if(alphabet[index] > alphabet[maxCountIndex])
//                maxCountIndex = index;
//
//        return (char)(maxCountIndex+'a');
//
//    }
}
