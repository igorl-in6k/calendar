import data.Day;
import data.MonthTable;
import data.Week;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class HtmlCalendarPrinter extends CalendarPrinter {
    PrintStream output;

    public HtmlCalendarPrinter() throws FileNotFoundException {
        output = new PrintStream(new File("Calendar.html"));
    }

    @Override
    protected void setup() {
        output.print("<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" href=\"style.css\">\n" +
                          "\t</head>\n<body>\n");
    }

    @Override
    protected void printTitle(String name, int year) {
        output.printf("\t<h1> %s %d </h1>\n", name, year);
        output.print("\t<table align=\"center\">\n\t\t<tr>");
        CalendarColor color;
        for (String SHORT_NAME_WEEK_DAY : Week.SHORT_NAMES_WEEK_DAYS) {
            if ( Day.isWeekendDay(SHORT_NAME_WEEK_DAY) )
                color = CalendarColor.WEEKEND_COLOR;
            else
                color = CalendarColor.HEADER_COLOR;
            output.print(String.format("\t\t\t<td style=\"%s\"> %s </td>\n",
                                                color.htmlValue, SHORT_NAME_WEEK_DAY));
        }
        output.print("\t\t</tr>");
    }

    @Override
    protected void startWeek() {
        output.print("\t\t<tr>\n");
    }

    @Override
    protected void printDay(Day day, MonthTable currentMonth) {
        String style = "color:" + getColor(day, currentMonth).htmlValue;
        if ( today.equalWith(day) )
            style += "; background-color: " + CalendarColor.CURRENT_DAY_BACKGROUND_COLOR.htmlValue;
        output.printf("\t\t\t<td style=\"%s\"> %d </td>\n", style, day.getDayOfMonth());
    }

    @Override
    protected void endWeek() {
        output.print("\t\t</tr>\n");
    }

    @Override
    protected void finish() {
        output.print("\t</table>\n</body>\n</html>");
        output.close();
    }

    private CalendarColor getColor(Day day, MonthTable currentMonth) {
        CalendarColor result = CalendarColor.CURRENT_MONTH_DAYS_COLOR;
        if (day.isWeekend())
            result = CalendarColor.WEEKEND_COLOR;
        if (today.equalWith(day))
            result = CalendarColor.CURRENT_DAY_COLOR;
        if (!currentMonth.isInMonth(day))
            result = CalendarColor.OTHER_MONTH_DAYS_COLOR;
        return result;
    }
}
