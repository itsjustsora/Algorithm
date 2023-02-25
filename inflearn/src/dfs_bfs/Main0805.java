package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0805 {

	static int N, M;
	static Integer[] coins;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		coins = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coins, Collections.reverseOrder());
		M = Integer.parseInt(br.readLine());

		DFS(0, 0, coins);
		System.out.println(answer);
	}

	private static void DFS(int L, int sum, Integer[] coins) {
		if (sum > M) return;
		if (L >= answer) return;
		if (sum == M) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < N; i++) {
				DFS(L+1, sum+coins[i], coins);
			}
		}
	}
}
