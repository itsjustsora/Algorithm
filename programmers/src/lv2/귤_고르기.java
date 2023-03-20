package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {
	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Arrays.sort(tangerine);

		Map<Integer, Integer> sizeMap = new HashMap<>();
		for (int size : tangerine) {
			sizeMap.put(size, sizeMap.getOrDefault(size, 0) + 1);
		}

		List<Integer> keyList = new ArrayList<>(sizeMap.keySet());

		keyList.sort((o1, o2) -> sizeMap.get(o2) - sizeMap.get(o1));

		for (Integer i : keyList) {
			if (k <= 0) break;
			answer++;
			k -= sizeMap.get(i);
		}
		return answer;
	}
}
