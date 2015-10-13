import data.Day;
import data.MonthTable;

import java.io.PrintStream;

public class HtmlCalendarPrinter extends CalendarPrinter {

    public HtmlCalendarPrinter(PrintStream stream) {
        super(stream);
    }

    @Override
    protected void setup() {
        output.print("<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" href=\"style.css\">\n" +
                          "\t</head>\n<body>\n");
    }

    @Override
    protected void startWeek() {
        output.print("\t\t<tr>\n");
    }

    @Override
    protected void printDay(Day day, MonthTable currentMonth) { // todo use css classes
        CalendarColor color = getDayColor(day, currentMonth);
        String style = String.format("style=\"color:%s\"", color.htmlValue);
        if ( today.equalWith(day) )
            style = "id=\"today\"";
        output.printf("\t\t\t<td %s> %d </td>\n", style, day.getDayOfMonth());
    }

    @Override
    protected void endWeek() {
        output.print("\t\t</tr>\n");
    }

    @Override
    protected void finish() {
        output.print("\t</table>\n</body>\n</html>");
    }

    protected void printTitle(MonthTable monthTable) {
        output.printf("\t<h1> %s %d </h1>\n", monthTable.getName(), monthTable.getYear());
        output.print("\t<table align=\"center\">\n");
    }

    @Override
    protected void printWeekdayTitle(String weekdayTitle, CalendarColor color) {
        output.printf("\t\t\t<td style=\"color:%s\"> %s </td>\n", color.htmlValue, weekdayTitle);
    }
}
