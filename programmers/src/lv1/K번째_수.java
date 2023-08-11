package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째_수 {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		List<Integer> list;
		int index = 0;

		for (int i = 0; i < commands.length; i++) {
			list = new ArrayList<>();
			int start = commands[i][0];
			int end = commands[i][1];
			int num = commands[i][2];

			for (int j = start - 1; j < end; j++) {
				list.add(array[j]);
			}

			Collections.sort(list);

			answer[index++] = list.get(num - 1);
		}
		return answer;
	}
}
