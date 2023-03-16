package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1006 {
	/*
		갯수가 정해져 있으면 뒤에서부터 앞으로 dp 계산
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		int[] dp = new int[M+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			for (int j = M; j >= time; j--) {
				dp[j] = Math.max(dp[j], dp[j-time]+score);
			}

		}
		System.out.println(dp[M]);
	}
}
