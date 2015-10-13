package data;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day {

    private int dayOfWeek; // todo
    private int dayOfMonth;
    private int weekIndex;
    private LocalDate date;

    public Day(int dayOfMonth, int dayOfWeek, int weekIdx) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.weekIndex = weekIdx;
    }

    public Day(LocalDate date) {
        this(date.getDayOfMonth(), date.getDayOfWeek().getValue(), 0);
        this.date = date;
    }

    public boolean isWeekend() {
        return dayOfWeek >= 6;
    }

    public boolean equalWith(Day anotherDay) {
        return this.dayOfMonth == anotherDay.dayOfMonth && this.dayOfWeek == anotherDay.dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeekIndex() {
        return weekIndex;
    }

    public static boolean isWeekendDay(String shortName) {
        return shortName.equals("Sat") || shortName.equals("Sun");
    }

    public static boolean isWeekendDay(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
