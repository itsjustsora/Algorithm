package lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
	public int[] solution(int n, String[] words) {
		int[] answer = {0, 0};

		Set<String> set = new HashSet<>();
		set.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			String previous = words[i-1];
			String now = words[i];

			char last = previous.charAt(previous.length()-1);
			char first = now.charAt(0);

			if (!set.contains(words[i]) && last == first) {
				set.add(words[i]);
			} else {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				break;
			}
		}
		return answer;
	}
}
