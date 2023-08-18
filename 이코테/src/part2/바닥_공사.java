package src.part2;

public class 바닥_공사 {

	static int[] dp = new int[1001];
	public static void main(String[] args) {
		System.out.println(solution(3));
	}

	public static int solution(int n) {
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + (dp[i-2] * 2) % 796796;
		}

		return dp[n];
	}
}
