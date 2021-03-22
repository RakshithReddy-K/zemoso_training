package oops;

public class Book {
    private String name;
    private String author;
    private String text="";
    public String getText()
    {
        return text;
    }
    public void appendText(String newText)
    {
        text = text.concat(newText);
    }
}
