import data.Day;
import data.Week;

import java.io.PrintStream;

public class AnsiCalendarPrinter extends CalendarPrinter {

    PrintStream output;

    public AnsiCalendarPrinter() {
        output = new PrintStream(System.out);
    }

    @Override
    protected void setup() {
        output.println("************************************");
    }

    @Override
    protected void printTitle(String name, int year) {
        output.println("\t\t\t" + name + " " + year);
        CalendarColor color;
        for (String SHORT_NAME_WEEK_DAY : Week.SHORT_NAMES_WEEK_DAYS) {
            if ( Day.isWeekendDay(SHORT_NAME_WEEK_DAY) )
                color = CalendarColor.WEEKEND_COLOR;
            else
                color = CalendarColor.HEADER_COLOR;
            setColor(color);
            output.printf("%4s", SHORT_NAME_WEEK_DAY);
        }
        output.println();
    }

    @Override
    protected void startWeek() {

    }

    @Override
    protected void printDay(Day day) {
        setAppropriateColor(day);
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

    private void setAppropriateColor(Day day) {
        CalendarColor result = CalendarColor.CURRENT_MONTH_DAYS_COLOR;
        if (day.isWeekend())
            result = CalendarColor.WEEKEND_COLOR;
        if (today.equalWith(day))
            result = CalendarColor.CURRENT_DAY_COLOR;
        if (!currentMonth.isInMonth(day))
            result = CalendarColor.OTHER_MONTH_DAYS_COLOR;
        setColor(result);
    }

    private void setColor(CalendarColor color) {
        output.print(color.consoleValue);
    }
}
