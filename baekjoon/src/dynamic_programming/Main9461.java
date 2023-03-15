package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			long[] dp = new long[100+1];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			for (int j = 3; j < num; j++) {
				dp[j] = dp[j - 2] + dp[j - 3];
			}
			sb.append(dp[num-1]).append("\n");
		}
		System.out.println(sb);
	}
}
