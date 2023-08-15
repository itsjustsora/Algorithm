package lv1;

import java.util.HashMap;
import java.util.Map;

public class 대충_만든_자판 {
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < keymap.length; i++) {
			String line = keymap[i];
			for (int j = 0; j < keymap[i].length(); j++) {
				char ch = line.charAt(j);
				int min = Math.min(map.getOrDefault(ch, Integer.MAX_VALUE), j+1);
				map.put(ch, min);
			}
		}

		for (int i = 0; i < targets.length; i++) {
			String line = targets[i];
			int cnt = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				char ch = line.charAt(j);
				int keyCount = map.getOrDefault(ch, Integer.MAX_VALUE);
				if (keyCount == Integer.MAX_VALUE) {
					cnt = -1;
					break;
				}
				cnt += keyCount;
			}
			answer[i] = cnt;
		}
		return answer;
	}
}
