public enum CalendarColor {

    WEEKEND_COLOR("\033[31m", "#8B0000"),
    CURRENT_DAY_COLOR("\033[1;34m", "black"),
    CURRENT_MONTH_DAYS_COLOR("\033[0m", "green"),
    HEADER_COLOR("\033[1;35m", "#00008B"),
    DEFAULT_COLOR("\033[0m", "green"),
    OTHER_MONTH_DAYS_COLOR("\033[36m", "#A9A9A9"),
    CURRENT_DAY_BACKGROUND_COLOR("","#90EE90");

    CalendarColor(String consoleCode, String htmlRepresentation) {
        this.consoleValue = consoleCode;
        this.htmlValue = htmlRepresentation;
    }

    public final String consoleValue;
    public final String htmlValue;
}
