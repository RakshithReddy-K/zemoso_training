package Course2;

import edu.duke.FileResource;

public class CaesarBreaker {

    public String decrypt(String encrypted,int key)
    {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }

    public String halfOfString(String message , int start)
    {
        String halfString="";
        int index;
        for(index=start;index<message.length();index+=2)
        {
            halfString=halfString+message.charAt(index);
        }
        return halfString;
    }
    public String decryptTwoKeys(String encrypted,int key1,int key2)
    {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encryptTwoKeys(encrypted, 26 - key1,26-key2);
        return message;
    }

    public int maxIndex(int[] values)
    {
        int maxIndex=0;
        for(int index=1;index<values.length;index++) {
            if (values[maxIndex] < values[index])
                maxIndex=index;
        }
        return maxIndex;
    }

    public int[] countLetters(String input)
    {
        int[] count=new int[26];
        int index;
        for(index=0;index<input.length();index++)
        {
            char ch=input.charAt(index);

            if(Character.isLetter(ch))
            {
                ch=Character.toLowerCase(ch);
                count[(int)ch-97]++;
            }

        }
        return count;
    }

    public int getKey(String s)
    {
        int[] count=countLetters(s);
        int max=maxIndex(count);
        int key;
        key=(max+1)-5;
        if(key<=0)
            key=key+26;
        return key;
    }

    public int[] getTwoKeys(String encrypted)
    {
        int[] keys=new int[2];
        keys[0]=getKey(halfOfString(encrypted,0));
        keys[1]=getKey(halfOfString(encrypted,1));
        return keys;
    }
    public void testDecrypt()
    {
        System.out.println(decrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!",15));
        System.out.println(decrypt("WZIJKCVXZFE",17));
        System.out.println(decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",2,20));
        System.out.println(halfOfString("Qbkm Zgis",0));
       System.out.println(halfOfString("Qbkm Zgis",1));
        System.out.println(decrypt("z yrmv cfkj fw vvvvvvvvvvvvvvvvj",17));
        System.out.println(getKey("z yrmv cfkj fw vvvvvvvvvvvvvvvvj"));
        int[] keys=getTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println("Key1= "+keys[0]+" Key2= "+keys[1]);

    }
}
