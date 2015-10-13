import data.Day;
import data.MonthTable;
import data.Week;

import java.time.LocalDate;

public abstract class CalendarPrinter {

    protected Day today;

    public CalendarPrinter() {
        today = new Day(LocalDate.now().getDayOfMonth(), LocalDate.now().getDayOfWeek().getValue(), 0);
    }

    public void print(MonthTable monthTable) {
        setup();
        printTitle(monthTable.getName(), monthTable.getYear());
        for (Week week : monthTable.getWeeks()) {
            startWeek();
            for (Day day : week.getDays()) {
                printDay(day, monthTable);
            }
            endWeek();
        }
        finish();
    }

    public void print() {
        print(new MonthTable(LocalDate.now().getYear(), LocalDate.now().getMonthValue()));
    }

    protected abstract void setup();

    protected abstract void printTitle(String name, int year);

    protected abstract void startWeek();

    protected abstract void printDay(Day day, MonthTable currentMonth);

    protected abstract void endWeek();

    protected abstract void finish();
}
