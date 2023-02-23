package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0802 {

	static int[] arr;
	static int C, N;
	static int total = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N+1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		DFS(0, 0, arr);
		System.out.println(total);
	}

	private static void DFS(int L, int sum, int[] arr) {
		if (sum > C) return;
		if (L == N) {
			if (sum < C) {
				total = Math.max(total, sum);
			}
		} else {
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
}
