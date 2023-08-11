package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두_개_뽑아서_더하기 {
	public int[] solution(int[] numbers) {
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];
				if (list.indexOf(sum) < 0) list.add(sum);
			}
		}

		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}
}
