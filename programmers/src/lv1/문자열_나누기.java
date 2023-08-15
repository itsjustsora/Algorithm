package lv1;

public class 문자열_나누기 {
	public int solution(String s) {
		int answer = 0;
		int cnt = 0;
		char init = '1';

		for (char ch : s.toCharArray()) {
			if (cnt == 0) {
				init = ch;
				cnt++;
			} else {
				if (init == ch) {
					cnt++;
				} else {
					cnt--;
				}
			}

			if (cnt == 0) {
				answer++;
			}
		}

		if (cnt > 0) answer++;

		return answer;
	}
}
