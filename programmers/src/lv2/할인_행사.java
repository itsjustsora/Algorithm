package lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 할인_행사 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> map = new HashMap<>();
		int len = want.length;
		for (int i = 0; i < len; i++) {
			map.put(want[i], number[i]);
		}

		int discountLen = discount.length;
		for (int i = 0; i <= discountLen - 10; i++) {
			Map<String, Integer> discountMap = new HashMap<>();
			for (int j = 0; j < 10; j++) {
				String item = discount[i + j];
				int cnt =discountMap.getOrDefault(item, 0);
				cnt++;
				discountMap.put(item, cnt);
			}

			boolean isSignup = true;
			for (String wantItem : map.keySet()) {
				int wantCount = map.get(wantItem);
				int discountCount = discountMap.getOrDefault(wantItem, 0);
				if (wantCount > discountCount) {
					isSignup = false;
					break;
				}
			}

			if (isSignup) {
				answer++;
			}
		}
		return answer;
	}
}
