package lv2;

import java.util.Arrays;

public class 구명보트 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int cnt = 0;
		int idx = 0;

		for (int i = people.length - 1; i >= idx; i--) {
			if (people[i] + people[idx] <= limit) {
				idx++;
				cnt++;
			}
			else {
				cnt++;
			}
		}
		return cnt;
	}
}
