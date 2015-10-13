import data.MonthTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CalendarPrinter cp = new AnsiCalendarPrinter();
        cp.print(new MonthTable(2015, 10));
        PrintStream stream = new PrintStream(new File("Calendar.html"));
        cp = new HtmlCalendarPrinter(stream);
        cp.print();
        stream.close();
    }
}