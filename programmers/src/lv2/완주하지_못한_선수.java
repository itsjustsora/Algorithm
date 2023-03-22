package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 완주하지_못한_선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		for (String person : participant) {
			map.put(person, map.getOrDefault(person, 0) + 1);
		}
		for (String person : completion) {
			map.put(person, map.get(person) - 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getValue() != 0) {
				answer += list.get(i).getKey();
			}
		}
		return answer;
	}
}
