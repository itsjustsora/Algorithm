package lv1;

public class 기사단원의_무기 {
	public int solution(int number, int limit, int power) {
		int answer = 0;
		int[] primeCount = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			primeCount[i] = getPrimeCnt(i);
		}

		for (int i = 1; i <= number; i++) {
			int cnt = primeCount[i];
			if (cnt <= limit) {
				answer += cnt;
			} else {
				answer += power;
			}
		}
		return answer;
	}

	private int getPrimeCnt(int num) {
		int count = 0;

		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				if (i * i == num) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		return count;
	}
}
