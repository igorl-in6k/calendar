package data;

public class Week {

    private Day[] days = new Day[7];
    private int weekIndex;
    public static final String[] SHORT_NAMES_WEEK_DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public Week(int from, int max, int weekIdx) {
        weekIndex = weekIdx;
        for (int i = 1; i <= 7; i++) {
            days[i-1] = new Day(from++, i, weekIndex);
            if ( from > max )
                from = 1;
        }
    }

    public Day[] getDays() {
        return days;
    }
}
