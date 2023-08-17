package lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고_결과_받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Map<String, Integer> map = new HashMap<>();
		Map<String, HashSet<String>> reportMap = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			String id = id_list[i];
			reportMap.put(id, new HashSet<>());
			map.put(id, i);
		}

		// 한 번에 한 명의 유저 신고, 동일 유저-유저 신고는 1회로 처리
		for(String record : report) {
			String[] split = record.split(" ");
			reportMap.get(split[1]).add(split[0]);
		}

		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> set = reportMap.get(id_list[i]);
			if (set.size() >= k) {
				for (String name : set) {
					answer[map.get(name)]++;
				}
			}
		}

		return answer;
	}
}
