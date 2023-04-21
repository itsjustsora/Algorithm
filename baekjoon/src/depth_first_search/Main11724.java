package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11724 {
	static int[][] graph;
	static boolean[] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());	// 정점
		m = Integer.parseInt(st.nextToken());	// 간선

		graph = new int[n+1][n+1];
		visited = new boolean[n+1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			graph[v1][v2] = graph[v2][v1] = 1;
		}

		int result = 0;

		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				DFS(i);
				result++;
			}
		}

		System.out.println(result);

	}

	private static void DFS(int i) {
		if (visited[i]) return;
		else {
			visited[i] = true;
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == 1) {
					DFS(j);
				}
			}
		}
	}
}
