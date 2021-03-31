package Course2;

public class WordPlay {
    public boolean isVowel(char ch)
    {
        char[] vowels={'a','e','i','o','u','A','E','I','O','U'};
        for(char c : vowels)
        {
            if(ch==c)
                return true;
        }
        return false;
    }

    public String replaceVowels(String phrase,char ch)
    {
        char[] replacedString=phrase.toCharArray();
        int iterator;
        for(iterator=0;iterator<phrase.length();iterator++)
        {
            char c=phrase.charAt(iterator);
            if(isVowel(c)==true)
                replacedString[iterator]=ch;
        }
        return new String(replacedString);
    }



    public String emphasize(String phrase,char ch)
    {

        char[] replacedString=phrase.toCharArray();
        int iterator;
        char[] replacingChars={'*','+'};
        for(iterator=0;iterator<phrase.length();iterator++)
        {
            char c=phrase.charAt(iterator);
            if(Character.toUpperCase(c)==ch || Character.toLowerCase(c)==ch)
                replacedString[iterator]=replacingChars[iterator%2];
        }
        return new String(replacedString);
    }


}
