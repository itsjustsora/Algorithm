package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0801 {

	static String answer = "NO";
	static int N, total = 0;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		DFS(0, 0, arr);
		System.out.println(answer);
	}

	private static void DFS(int L, int sum, int[] arr) {
		if (flag) return;
		if (sum > (total / 2)) return;
		if (L == N) {
			if ((total / 2) == sum) {
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
}
