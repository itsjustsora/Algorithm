package lv2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 위장 {
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
		Iterator<Integer> it = map.values().iterator();
		while(it.hasNext()) {
			answer *= it.next().intValue() + 1;
		}
		return answer - 1;
	}
}
