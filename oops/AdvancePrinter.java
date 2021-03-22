package oops;

public class AdvancePrinter extends BookPrinter{
    private Book reference;
    AdvancePrinter(Book reference) {
        this.reference=reference;
    }
    public void printText()
    {

            System.out.println("<<<<"+reference.getText()+">>>>");
    }
}
