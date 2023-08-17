package src.part2;

public class 개미_전사 {

	public static int[] dp;
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {1, 3, 1, 5}));
	}

	public static int solution(int n, int[] storage) {
		dp = new int[n];
		dp[0] = storage[0];
		dp[1] = Math.max(storage[0], storage[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + storage[i]);
		}
		return dp[n - 1];
	}
}
