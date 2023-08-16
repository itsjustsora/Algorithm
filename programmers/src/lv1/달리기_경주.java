package lv1;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> map = new HashMap<>();
		String[] answer = new String[players.length];


		int idx = 0;
		for (String player : players) {
			map.put(player, idx++);
		}

		for (String name : callings) {
			int index = map.get(name);
			String beforeName = players[index - 1];

			players[index] = beforeName;
			players[index - 1] = name;

			map.put(name, index - 1);
			map.put(beforeName, index);
		}


		return players;
	}
}
