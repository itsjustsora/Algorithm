package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1003 {
	// 최대부분증가수열(LIS)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] origin = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		dp[0] = 1;
		int answer = 0;
		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = i-1; j>=0; j--) {
				if (origin[j] < origin[i] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);

	}
}
