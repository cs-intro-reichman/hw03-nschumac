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

    public static void main(String args[]) {
        int calendarYear = Integer.parseInt(args[0]);

        while (Calendar.year < calendarYear + 1) {
            if (Calendar.year == calendarYear) {
                System.out.println(Calendar.dayOfMonth + "\\"
                        + Calendar.month + "\\"
                        + Calendar.year
                        + (Calendar.dayOfWeek == 1 ? " Sunday"
                                : ""));
            }
            advance();
        }
    }

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

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0
                || (year % 100 > 0 && year % 4 == 0));
    }

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
