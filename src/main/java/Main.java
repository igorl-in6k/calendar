import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CalendarPrinter cp = new AnsiCalendarPrinter();
        cp.print();
        cp = new HtmlCalendarPrinter();
        cp.print();
    }
}
