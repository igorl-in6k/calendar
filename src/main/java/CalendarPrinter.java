import data.Day;
import data.MonthTable;
import data.Week;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class CalendarPrinter {

    protected Day today;
    PrintStream output;

    public CalendarPrinter() {
        this(System.out);
    }

    public CalendarPrinter(PrintStream output) {
        this(output, LocalDate.now());
    }

    public CalendarPrinter(PrintStream output, LocalDate today) {
        this.today = new Day(today);
        this.output = output;
    }

    public void print() {
        print(new MonthTable(LocalDate.now()));
    }

    public void print(MonthTable monthTable) {
        setup();
        printTitle(monthTable);
        startWeek();
        printWeekdayTitles();
        endWeek();
        for (Week week : monthTable.getWeeks()) {
            startWeek();
            for (Day day : week.getDays()) {
                printDay(day, monthTable);
            }
            endWeek();
        }
        finish();
    }

    protected abstract void printTitle(MonthTable monthTable);
    protected abstract void setup();
    protected abstract void startWeek();
    protected abstract void printDay(Day day, MonthTable currentMonth);
    protected abstract void endWeek();
    protected abstract void finish();

    protected void printWeekdayTitles() {
        CalendarColor color;
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if ( Day.isWeekendDay(dayOfWeek) )
                color = CalendarColor.WEEKEND_COLOR;
            else
                color = CalendarColor.HEADER_COLOR;
            printWeekdayTitle(dayOfWeek.toString().substring(0, 3), color);
        }
    }

    protected abstract void printWeekdayTitle(String weekdayTitle, CalendarColor color);

    protected CalendarColor getDayColor(Day day, MonthTable currentMonth) {
        CalendarColor color = CalendarColor.CURRENT_MONTH_DAYS_COLOR;
        if (day.isWeekend())
            color = CalendarColor.WEEKEND_COLOR;
        if (today.equalWith(day))
            color = CalendarColor.CURRENT_DAY_COLOR;
        if (!currentMonth.isInMonth(day))
            color = CalendarColor.OTHER_MONTH_DAYS_COLOR;

        return color;
    }
}
