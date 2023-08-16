package lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int todayNum = getDateInt(today);

		for (String term : terms) {
			String[] termsInfo = term.split(" ");
			map.put(termsInfo[0], Integer.parseInt(termsInfo[1]) * 28);
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] split = privacies[i].split(" ");

			int personalNum = getDateInt(split[0]);
			int termNum = map.get(split[1]);

			if (todayNum >= personalNum + termNum) {
				list.add(i + 1);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public int getDateInt(String date) {
		String[] dateInfo = date.split("[.]");
		int year = Integer.parseInt(dateInfo[0].substring(2,4));
		int month = Integer.parseInt(dateInfo[1]);
		int day = Integer.parseInt(dateInfo[2]);

		return (year * 12 * 28) + (month * 28) + day;
	}
}
