package Course2;

public class Main {
    public static void main(String[] args)
    {
        WordPlay test= new WordPlay();
     //   System.out.println(test.isVowel('A'));
       // System.out.println(test.replaceVowels("Hello World",'*'));
        //System.out.println(test.emphasize("dna ctgaaactga",'a'));
       // System.out.println(test.emphasize("Mary Bella Abracadabra",'a'));
        //CaesarCipher cipher=new CaesarCipher();
        //cipher.tester();
       // WordLengths word=new WordLengths();
        //word.testCountWordLengths();
       // CaesarBreaker decipher=new CaesarBreaker();
        //decipher.testDecrypt();
        int a=5;
        switch (a)
        {
            default :a=4;

            case 5:a=a+1;
            case 1:a=a-5;
            case 6: a--;
        }
        System.out.println(a);
    }
}
