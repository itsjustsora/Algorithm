package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main24416 {

	public static int recursiveCnt = 0;
	public static int dpCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		recursive(N);
		dp(N);
		sb.append(recursiveCnt).append(" ").append(dpCnt);
		System.out.println(sb);
	}

	private static int recursive(int n) {
		if (n == 1 || n == 2) {
			recursiveCnt++;
			return 1;
		}
		return (recursive(n - 1) + recursive(n - 2));
	}

	private static void dp(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
			dpCnt++;
		}
	}
}
