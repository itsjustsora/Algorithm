package lv1;

public class 둘만의_암호 {
	public String solution(String s, String skip, int index) {
		String answer = "";
		char next = ' ';

		for (char ch : s.toCharArray()) {
			int idx = index;
			for (int i = 1; i <= idx; i++) {
				next = (char) ('a' + (ch  - 'a' + i) % 26) ;
				if (skip.contains(String.valueOf(next))) idx++;
			}
			answer += next;
		}
		return answer;
	}
}
