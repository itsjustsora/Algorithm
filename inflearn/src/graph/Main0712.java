package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0712 {

	/**
	 * 경로탐색 - 인접행렬
	 */

	static int N, M, answer = 0;
	static int[][] map;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		check = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 방향 그래프니까 [a][b]만 1로 만들어주기
			map[a][b] = 1;
		}

		check[1] = true;
		DFS(1);
		System.out.println(answer);


	}

	private static void DFS(int v) {
		if (v == N) answer++;
		else {
			for (int i = 1; i <= N; i++) {
				if (map[v][i] == 1 && !check[i]) {
					check[i] = true;
					DFS(i);
					check[i] = false;
				}
			}
		}
	}
}
