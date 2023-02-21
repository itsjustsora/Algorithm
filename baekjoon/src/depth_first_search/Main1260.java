package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

	static int[][] map;
	static boolean[] check;
	static int M, N;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		N = Integer.parseInt(st.nextToken());	// 정점의 개수
		M = Integer.parseInt(st.nextToken());	// 간선의 개수
		int V = Integer.parseInt(st.nextToken());	// 탐색을 시작할 정점의 번호

		map = new int[N+1][N+1];
		check = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
		}
		dfs(V);
		sb.append("\n");

		check = new boolean[N+1];
		bfs(V);

		System.out.println(sb);

	}

	private static void dfs(int start) {
		check[start] = true;
		sb.append(start).append(" ");

		for (int i = 0; i <= N; i++) {
			if (map[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		queue.add(start);
		check[start] = true;

		while (!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start).append(" ");

			for (int i = 1; i <= N; i++) {
				if (map[start][i] == 1 && !check[i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
	}
}
