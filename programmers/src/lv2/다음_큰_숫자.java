package lv2;

public class 다음_큰_숫자 {
	public int solution(int n) {
		int answer = 0;
		int n_cnt = 0;
		int temp = n;

		while (temp > 0) {
			if (temp % 2 == 1) n_cnt++;
			temp /= 2;
		}

		for (int i = n+1; i <= 1000000; i++) {
			int cnt = 0;
			int num = i;
			while (num > 0) {
				if(num % 2 == 1) cnt++;
				num /=  2;
			}
			if (cnt == n_cnt) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}
