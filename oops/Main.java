package oops;

public class Main {
    public static void main(String[] args)
    {
        Book harryPotter=new Book();
        harryPotter.appendText("This is Harry Potter.First part is harry potter and sorcerer's stone.Second part is harry potter and chamber of secrets.");
        BookPrinter printer=new BookPrinter(harryPotter);
        printer.printText();
        BookPrinter newPrinter=new AdvancePrinter(harryPotter);
        newPrinter.printText();
    }
}
