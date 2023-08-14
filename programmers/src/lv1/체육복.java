package lv1;

public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] uni = new int[n+2];

		for (int i : lost) {
			uni[i]--;
		}

		for (int i : reserve) {
			uni[i]++;
		}

		for (int i = 1; i <= n; i++) {
			if (uni[i] == -1) {
				if (i - 1 >= 1 && uni[i-1] == 1) {
					uni[i-1]--;
					uni[i]++;
				}
				else if (i + 1 <= n && uni[i+1] == 1) {
					uni[i+1]--;
					uni[i]++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (uni[i] >= 0) answer++;
		}

		return answer;
	}
}
