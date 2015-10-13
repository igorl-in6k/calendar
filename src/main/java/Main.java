import data.MonthTable;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("Calendar.html");
        CalendarPrinter cp = new HtmlCalendarPrinter(ps);
        for (int i = 1; i <= 12; i++) {
            cp.print(new MonthTable(2015, i));
        }
    }
}