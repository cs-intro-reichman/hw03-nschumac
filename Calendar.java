/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this
     * period.
     */
    public static void main(String args[]) {
        int calendarYear = Integer.parseInt(args[0]);

        while (Calendar.year < calendarYear + 1) {
            if (Calendar.year == calendarYear) {
                System.out.println(Calendar.dayOfMonth + "\\"
                        + Calendar.month + "\\"
                        + Calendar.year
                        + (Calendar.dayOfWeek == 1 ? " sunday"
                                : ""));
            }
            advance();
        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {
        Calendar.dayOfWeek++;
        if (Calendar.dayOfWeek > 7) {
            Calendar.dayOfWeek = 1;
        }
        Calendar.dayOfMonth++;
        if (Calendar.dayOfMonth > nDaysInMonth(
                Calendar.month, Calendar.year)) {
            Calendar.dayOfMonth = 1;
            Calendar.month++;

            if (Calendar.month > 12) {
                Calendar.month = 1;
                Calendar.year++;
            }
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0
                || (year % 100 > 0 && year % 4 == 0));
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        switch (month) {
            case 2: // february
                return isLeapYear(year) ? 29 : 28;
            case 4: // april
            case 6: // june
            case 9: // september
            case 11: // november
                return 30;
            default:
                return 31;
        }
    }
}
