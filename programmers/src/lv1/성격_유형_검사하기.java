package lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
	public String solution(String[] survey, int[] choices) {
		String answer = "";
		Map<Character, Integer> map = new HashMap<>();
		char[] typeArr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
		int[] choiceScore = {0, 3, 2, 1, 0, 1, 2, 3};

		for (char ch : typeArr) {
			map.put(ch, 0);
		}

		for (int i = 0; i < survey.length; i++) {
			int choice = choices[i];
			char first = survey[i].charAt(0);
			char second = survey[i].charAt(1);

			if (choice < 4) {
				map.put(first, map.getOrDefault(first, 0) + choiceScore[choice]);
			} else if (choice > 4) {
				map.put(second, map.getOrDefault(second, 0) + choiceScore[choice]);
			}
		}

		for (int i = 0; i < typeArr.length; i += 2) {

			char type1 = typeArr[i];
			char type2 = typeArr[i+1];

			if (map.get(type1) >= map.get(type2)) {
				answer += type1;
			} else {
				answer += type2;
			}
		}
		return answer;
	}
}
