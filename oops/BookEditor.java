package oops;

public class BookEditor extends Book{
    private String text=super.getText();

    public String findWordAndDelete(String word) {
        if (text.contains(word)) {
            text = text.replace(word, "");
        }
        return text;
    }
}
