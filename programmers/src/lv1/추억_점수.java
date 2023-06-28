package lv1;

import java.util.HashMap;

public class 추억_점수 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}

		for (int i = 0; i < photo.length; i++) {
			int cnt = 0;
			for (int j = 0; j < photo[i].length; j++) {
				cnt += map.getOrDefault(photo[i][j], 0);
			}
			answer[i] = cnt;
		}
		return answer;
	}
}
