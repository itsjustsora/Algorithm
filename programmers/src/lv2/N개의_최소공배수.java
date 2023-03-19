package lv2;

public class N개의_최소공배수 {
	public int solution(int[] arr) {
		int answer = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int a = Math.max(answer, arr[i]);
			int b = Math.min(answer, arr[i]);

			answer = answer * arr[i] / gcd(a, b);
		}
		return answer;
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
