package lv2;

public class 피보나치_수 {
	public int solution(int n) {
		int[] F = new int[n+1];
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = (F[i-2] + F[i-1]) % 1234567;
		}
		return F[n];
	}
}
