package src.part2;

public class 일로_만들기 {

	public static int[] dp = new int[30001];
	public static void main(String[] args) {
		System.out.println(solution(26));
	}

	public static int solution(int x) {
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			if (i % 5 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			}
		}
		return dp[x];
	}
}
