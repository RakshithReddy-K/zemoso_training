package oops;

public class BookPrinter implements Printing{
    Book reference;
    BookPrinter()
    {}
    BookPrinter(Book reference)
    {
        this.reference=reference;
    }
    public void printText()
    {
        System.out.println(reference.getText());
    }
}
