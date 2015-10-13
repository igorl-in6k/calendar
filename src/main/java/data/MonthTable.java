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
            weeks[0] = new Week(1, 7, 1);
        else {
            int firstWeekOffset = weekDayOfFirstDayInMonth - 2;
            int b = previousMonthLength - firstWeekOffset;
            weeks[0] = new Week(b, previousMonthLength, 1);
        }
        int lastFilledDay = weeks[0].getDays()[6].getDayOfMonth();
        for (int weekIdx = 1; weekIdx < 6; weekIdx++) {
            weeks[weekIdx] = new Week(lastFilledDay + 1, monthLength, weekIdx + 1);
            lastFilledDay = weeks[weekIdx].getDays()[6].getDayOfMonth();
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
        if ( (someDay.getDayOfMonth() > 25 && someDay.getWeekIndex() == 1) ||
             (someDay.getDayOfMonth() < 15 && someDay.getWeekIndex() >= 5) )
            return false;
        return true;
    }
}
