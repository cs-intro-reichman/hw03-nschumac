import java.util.Calendar;

/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.

	 	while (Calendar1.year < 2000) {
            System.out.println(Calendar1.dayOfMonth + "\\" + Calendar1.month + "\\" + Calendar1.year + (Calendar1.dayOfWeek == 1 ? " sunday" : ""));
	 		advance();
        }
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		// Replace this comment with your code
        Calendar1.dayOfWeek = (Calendar1.dayOfWeek + 1) % 8 + 1;
        Calendar1.dayOfMonth++;
        if (Calendar1.dayOfMonth > nDaysInMonth(Calendar1.month, Calendar1.year)) {
            Calendar1.dayOfMonth = 1;
            Calendar1.month++;

            if (Calendar1.month > 12) {
                Calendar1.month = 1;
                Calendar1.year++;
            }
        }
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 100 > 0 &&  year % 4 == 0));
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // february
                return isLeapYear(year) ? 29 : 28;
            case 3: // april
            case 4: // june
            case 8: // september
            case 10: // november
                return 30;
            default:
                return 31;
        }
	}
}
