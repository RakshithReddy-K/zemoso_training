package Course2;

public class CaesarCipher {
    public String encrypt(String input,int key)
    {
        key=key%26;
        char[] encrypted=input.toCharArray();
        char encryptedChar,ch;
        int upper='A';
        int lower='a';
        int iterator;
        for(iterator=0;iterator<input.length();iterator++)
        {
            ch=encrypted[iterator];
            int i=ch;
            if(i<upper || (i>=upper+26 && i<lower ) || i>=lower+26)
            {
                encryptedChar=ch;
            }
            else if (Character.isUpperCase(ch)) {
                encryptedChar = (char) (((int) ch + key - upper) % 26 + upper);
            }
            else {
                encryptedChar = (char) (((int) ch + key - lower) % 26 + lower);
            }
            encrypted[iterator]=encryptedChar;
        }
        return new String(encrypted);
    }
    public String encryptTwoKeys(String input,int key1,int key2)
    {
        key1=key1%26;
        key2=key2%26;
        int[] keys={key1,key2};
        char[] encrypted=input.toCharArray();
        char encryptedChar,ch;
        int upper='A';
        int lower='a';
        int iterator;
        for(iterator=0;iterator<input.length();iterator++)
        {
            ch=encrypted[iterator];
            int i=ch;
            if(i<upper || (i>=upper+26 && i<lower ) || i>=lower+26)
            {
                encryptedChar=ch;
            }
            else if (Character.isUpperCase(ch)) {
                encryptedChar = (char) (((int) ch + keys[iterator%2] - upper) % 26 + upper);
            }
            else {
                encryptedChar = (char) (((int) ch + keys[iterator%2] - lower) % 26 + lower);
            }
            encrypted[iterator]=encryptedChar;
        }
        return new String(encrypted);

    }


    public void tester()
    {
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        System.out.println(encrypt("i have lots of eeeeeeeeeeeeeeees",17));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));

    }
}
