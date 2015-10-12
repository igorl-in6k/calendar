package data;

public class Week {

    private Day[] days = new Day[7];

    public Week(int from, int max) {
        for (int i = 1; i <= 7; i++) {
            days[i-1] = new Day(from++, i);
            if ( from > max )
                from = 1;
        }
    }

    public Day[] getDays() {
        return days;
    }
}
