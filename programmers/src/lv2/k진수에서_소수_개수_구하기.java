package lv2;

public class k진수에서_소수_개수_구하기 {
	public int solution(int n, int k) {
		int answer = 0;
		String number = k == 10 ? String.valueOf(n) : convert(n, k);
		String[] nums = number.split("0+");

		for (String value : nums) {
			if (check(Long.parseLong(value))) {
				answer++;
			}
		}
		return answer;
	}

	private String convert(int num, int base) {
		int quotient = num / base;
		int remainder = num % base;
		if (quotient != 0) {
			return convert(quotient, base) + String.valueOf(remainder);
		} else {
			return String.valueOf(remainder);
		}
	}

	private boolean check(long num) {
		if (num == 2) return true;
		if (num == 1 || num % 2 == 0) return false;

		for (long i = 3; i <= (long) Math.sqrt(num); i += 2) {
			if (num % i == 0) return false;
		}

		return true;
	}
}
