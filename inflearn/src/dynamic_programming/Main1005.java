package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] coins = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		System.out.println(solution(coins, M));

	}

	private static int solution(int[] coins, int m) {
		int[] dp = new int[m+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <=m; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}

		return dp[m];
	}
}
