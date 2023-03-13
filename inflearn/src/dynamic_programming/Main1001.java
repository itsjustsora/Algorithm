package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N]);

	}
}
