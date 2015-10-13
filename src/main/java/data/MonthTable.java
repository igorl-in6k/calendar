package data;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class MonthTable {

    private Week[] weeks = new Week[6];

    private Month month;
    private int year;

    public MonthTable(int y, int mIndex) {
        year = y;
        month = Month.of(mIndex);
        int monthLength = month.length(Year.isLeap(year));

        int previousMonthLength = Month.of(mIndex).minus(1).length(Year.isLeap(year));
        int weekdayOfFirstDayInMonth = LocalDate.of(year, month.getValue(), 1).getDayOfWeek().getValue();

        if (weekdayOfFirstDayInMonth == 1)
            weeks[0] = new Week(1, 7, 1);
        else {
            int firstWeekOffset = weekdayOfFirstDayInMonth - 2;
            weeks[0] = new Week(previousMonthLength - firstWeekOffset, previousMonthLength, 1);
        }
        int lastAddedDay = weeks[0].getDays()[6].getDayOfMonth();
        for (int weekIdx = 1; weekIdx < 6; weekIdx++) {
            weeks[weekIdx] = new Week(lastAddedDay + 1, monthLength, weekIdx + 1);
            lastAddedDay = weeks[weekIdx].getLastDay().getDayOfMonth();
        }
    }

    public MonthTable(LocalDate now) {
        this(now.getYear(), now.getMonth().getValue());
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
        return !((someDay.getDayOfMonth() > 25 && someDay.getWeekIndex() == 1) ||
                (someDay.getDayOfMonth() < 15 && someDay.getWeekIndex() >= 5));
    }
}
