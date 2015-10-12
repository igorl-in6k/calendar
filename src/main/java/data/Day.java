package data;

public class Day {

    private int dayOfWeek;
    private int dayOfMonth;
    private int weekIndex;

//    public Day(int dayOfMonth, int dayOfWeek) {
//        this.dayOfMonth = dayOfMonth;
//        this.dayOfWeek = dayOfWeek;
//    }

    public Day(int dayOfMonth, int dayOfWeek, int weekIdx) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.weekIndex = weekIdx;
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
}
