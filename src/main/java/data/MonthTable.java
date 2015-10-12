package data;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class MonthTable {

    private Week[] weeks = new Week[6];

    private Month month;
    private int monthIndex;
    private int monthLength;
    private int year;

    public MonthTable() {
        this(LocalDate.now().getYear(), LocalDate.now().getMonth().getValue());
    }

    public MonthTable(int y, int mIndex) {
        monthIndex = mIndex;
        year = y;
        month = Month.of(monthIndex);
        monthLength = month.length(Year.isLeap(year));

        int previousMonthLength = Month.of(monthIndex).minus(1).length(Year.isLeap(year));
        int weekDayOfFirstDayInMonth = LocalDate.of(year, month.getValue(), 1).getDayOfWeek().getValue();

        if ( weekDayOfFirstDayInMonth == 1 )
            weeks[0] = new Week(1, 7);
        else {
            int firstWeekOffset = weekDayOfFirstDayInMonth - 2;
            int b = previousMonthLength - firstWeekOffset;
            weeks[0] = new Week(b, previousMonthLength);
        }
        int lastFilledDay = weeks[0].getDays()[6].getDayOfMonth();
        for (int i = 1; i < 6; i++) {
            weeks[i] = new Week(lastFilledDay + 1, monthLength);
            lastFilledDay = weeks[i].getDays()[6].getDayOfMonth();
        }
    }

    public Week[] getWeeks() {
        return weeks;
    }

    public String getName() {
        return month.toString();
    }

    public int getYear() {
        return year;
    }

    public boolean isInMonth(Day someDay) {
        boolean isAnotherMonth = true;
        for (Week week : weeks) {
            for (Day day : week.getDays()) {
                if ( day.getDayOfMonth() == 1 )
                    isAnotherMonth = !isAnotherMonth;
                if ( day.equalWith(someDay) )
                    return !isAnotherMonth;
            }
        }
        return false;
    }
}
