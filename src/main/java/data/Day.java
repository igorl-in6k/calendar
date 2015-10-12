package data;

public class Day {

    private int dayOfWeek;
    private int dayOfMonth;

    public Day(int dayOfMonth, int dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
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
}
