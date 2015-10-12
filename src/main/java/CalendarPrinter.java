import data.Day;
import data.MonthTable;
import data.Week;

import java.time.LocalDate;

public abstract class CalendarPrinter {

    protected Day today;
    protected MonthTable currentMonth;

    public void print(MonthTable monthTable) {
        today = new Day(LocalDate.now().getDayOfMonth(), LocalDate.now().getDayOfWeek().getValue(), 0);
        currentMonth = monthTable;

        setup();
        printTitle(monthTable.getName(), monthTable.getYear());
        for (Week week : monthTable.getWeeks()) {
            startWeek();
            for (Day day : week.getDays()) {
                printDay(day);
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

    protected abstract void printDay(Day day);

    protected abstract void endWeek();

    protected abstract void finish();
}
