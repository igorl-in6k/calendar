package data;

public class Week {

    private Day[] days = new Day[7];
    private int weekIndex;
    public static final String[] SHORT_NAMES_WEEK_DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public Week(int from, int max, int weekIdx) {
        weekIndex = weekIdx;
        for (int dayIdx = 1; dayIdx <= 7; dayIdx++) {
            if ( from > max )
                from = 1;
            days[dayIdx-1] = new Day(from++, dayIdx, weekIndex);
        }
    }

    public Day[] getDays() {
        return days;
    }

    public Day getFirstDay() {
        return days[0];
    }

    public Day getLastDay() {
        return days[6];
    }
}
