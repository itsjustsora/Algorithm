package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class 튜플 {
	public int[] solution(String s) {
		Queue<Integer> queue = new LinkedList<>();
		char[] chs = s.toCharArray();
		String[] str = s.replaceAll("[{}]", "").split(",");

		int[] answer = new int[str.length];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			map.put(str[i], map.getOrDefault(str[i],0) + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (o1, o2) -> {
			return o2.getValue() - o1.getValue();
		});

		answer = new int[list.size()];

		for(int i = 0; i < answer.length; i++){
			answer[i] = Integer.parseInt(list.get(i).getKey());
		}
		return answer;
	}
}
