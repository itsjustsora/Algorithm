package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0803 {

	static int[] scores;
	static int[] times;
	static int answer = Integer.MIN_VALUE;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		scores = new int[N+1];
		times = new int[N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			scores[i] = Integer.parseInt(st.nextToken());
			times[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0, 0, 0, scores, times);
		System.out.println(answer);

	}

	private static void DFS(int index, int sum, int time, int[] ps, int[] pt) {
		if (time > M) return;
		if (index == N) {
			answer = Math.max(answer, sum);
		} else {
			DFS(index + 1, sum + ps[index], time + pt[index], ps, pt);
			DFS(index + 1, sum, time, ps, pt);
		}
	}
}
