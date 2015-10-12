import data.MonthTable;

public class Main {

    public static void main(String[] args) {
        CalendarPrinter cp = new AnsiCalendarPrinter();
        cp.print(new MonthTable(2015, 10));
    }
}
