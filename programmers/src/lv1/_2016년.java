package lv1;

import java.util.Calendar;

public class _2016년 {
	public String solution(int a, int b) {
		String answer = "";
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, a-1);
		cal.set(Calendar.DAY_OF_MONTH, b);
		answer = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		return answer;
	}

	/**
	 * OR
	 * LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
	 */
}
