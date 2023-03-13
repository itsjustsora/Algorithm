package lv2;

public class 숫자의_표현 {
	public int solution(int n) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i +1; j<= n; j++) {
				sum += j;
				if (sum == n) cnt++;
				else if (sum > n) break;
			}
		}
		return cnt;
	}
}
