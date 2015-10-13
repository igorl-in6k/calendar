import data.Day;
import data.MonthTable;
import data.Week;

public class AnsiCalendarPrinter extends CalendarPrinter {

    @Override
    protected void setup() {
        output.println("************************************");
    }

    @Override
    protected void startWeek() {
    }

    @Override
    protected void printDay(Day day, MonthTable currentMonth) {
        CalendarColor color = getDayColor(day, currentMonth);
        setColor(color);
        output.printf("%4d", day.getDayOfMonth());
    }

    @Override
    protected void endWeek() {
        output.println();
    }

    @Override
    protected void finish() {
        setColor(CalendarColor.DEFAULT_COLOR);
        output.println("************************************");
    }

    private void setColor(CalendarColor color) {
        output.print(color.consoleValue);
    }

    @Override
    protected void printTitle(MonthTable monthTable) {
        output.println("\t\t\t" + monthTable.getName() + " " + monthTable.getYear()); // todo printf
    }

    @Override
    protected void printWeekdayTitle(String weekdayTitle, CalendarColor color) {
        setColor(color);
        output.printf("%4s", weekdayTitle);
    }
}
