import data.MonthTable;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CalendarPrinter cp = new AnsiCalendarPrinter();
        cp.print(new MonthTable(2015, 2));
        cp = new HtmlCalendarPrinter();
        cp.print(new MonthTable(2015, 2));
    }
}
