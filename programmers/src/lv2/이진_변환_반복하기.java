package lv2;

import java.util.ArrayList;
import java.util.List;

public class 이진_변환_반복하기 {
	public int[] solution(String s) {
		int[] answer = new int[2];

		int cnt = 0;
		int zero = 0;

		while(!s.equals("1")) {
			int len = s.length();
			s = s.replace("0", "");
			zero += len - s.length();
			len = s.length();

			List<Integer> list = new ArrayList<>();
			while (len > 1) {
				list.add(len % 2);
				len /= 2;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("1");
			for (int i = list.size() - 1; i >= 0; i--) {
				sb.append(list.get(i));
			}

			s = sb.toString();
			cnt++;
		}

		answer[0] = cnt;
		answer[1] = zero;

		return answer;
	}
}
