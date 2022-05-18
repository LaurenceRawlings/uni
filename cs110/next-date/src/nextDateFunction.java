import java.util.Scanner;

public class nextDateFunction {

	public static boolean monthIsInRange(int month) {
		return ((1 <= month) && month <= 12);
	}

	public static boolean dayIsInRange(int day) {
		return ((1 <= day) && day <= 31);
	}

	public static boolean yearIsInRange(int year) {
		return ((1812 <= year) && year <= 2012);
	}

	public static boolean hasThirtyOneDaysAndIsNotDecember(int month) {
		return (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 10);
	}

	public static boolean hasThirtyDays(int month) {
		return (month == 4) || (month == 6) || (month == 9) || (month == 11);
	}

	public static boolean isFebruary(int month) {
		return (month == 2);
	}

	public static boolean isDecember(int month) {
		return (month == 12);
	}

	public static boolean isCenturyYear(int year) {
		return (year % 100 == 0);
	}

	public static boolean isLeapYear(int year) {
		if (isCenturyYear(year)) {
			return (year % 400) == 0;
		} else {
			return (year % 4) == 0;
		}

	}

	// works for correct inputs only
	public static String computeTomorrow(int day, int month, int year) {
		String s = "";
		int tomorrowDay;
		int tomorrowMonth;
		int tomorrowYear;
		if (hasThirtyOneDaysAndIsNotDecember(month)) {
			if (day < 31) {
				tomorrowDay = day + 1;
				tomorrowMonth = month;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			} else {
				tomorrowDay = 1;
				tomorrowMonth = month + 1;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			}
		} else if (hasThirtyDays(month)) {
			if (day < 30) {
				tomorrowDay = day + 1;
				tomorrowMonth = month;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			} else if (day > 30) {
				s = s + "Invalid input date";

			} else {
				tomorrowDay = 1;
				tomorrowMonth = month + 1;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			}
		} else if (isDecember(month)) {
			if (day < 31) {
				tomorrowDay = day + 1;
				tomorrowMonth = month;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			} else {
				if (year == 2012) {
					s = "Next day out of range";
				} else {
					tomorrowDay = 1;
					tomorrowMonth = 1;
					tomorrowYear = year + 1;
					s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
				}
			}
		} else if (isFebruary(month)) {
			if (day <= 27) {
				tomorrowDay = day + 1;
				tomorrowMonth = month;
				tomorrowYear = year;
				s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
			} else if (day == 28) {
				if (isLeapYear(year)) {
					tomorrowDay = day + 1;
					tomorrowMonth = month;
					tomorrowYear = year;
					s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
				} else { // not a leap year
					tomorrowDay = 1;
					tomorrowMonth = 3;
					tomorrowYear = year;
					s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
				}
			} else if (day == 29) {
				if (isLeapYear(year)) {
					tomorrowDay = 1;
					tomorrowMonth = 3;
					tomorrowYear = year;
					s = s + tomorrowDay + "." + tomorrowMonth + ".---" + tomorrowYear;
				} else { // not a leap year
					s = s + "Invalid input date";
				}
			} else if (day >= 30) {
				s = s + "Invalid input date";
			}
		}
		return s;
	}

	// takes input error into account
	public static String tomorrow(int day, int month, int year) {
		String s = "";
		if (monthIsInRange(month) && dayIsInRange(day) && yearIsInRange(year)) {
			s = computeTomorrow(day, month, year);
		} else {
			if (!monthIsInRange(month)) {
				s = s + "month out of range";
			}
			if (!dayIsInRange(month)) {
				s = s + "day out of range";
			}
			if (!yearIsInRange(month)) {
				s = s + "year out of range";
			}
		}
		return s;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.print("Day: ");
		int d = input.nextInt();

		System.out.print("Month: ");
		int m = input.nextInt();

		System.out.print("Year: ");
		int y = input.nextInt();

		System.out.println(tomorrow(d, m, y));
	}

}
