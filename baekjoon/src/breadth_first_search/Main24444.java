package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main24444 {

	static int[] visited;
	static int cnt;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		visited = new int[n+1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		cnt = 1;
		BFS(r);

		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);

	}

	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();

		visited[index] = cnt;

		queue.offer(index);

		while (!queue.isEmpty()) {
			int cv = queue.poll();
			for (int nv : graph.get(cv)) {
				if (visited[nv] == 0) {
					cnt++;
					queue.offer(nv);
					visited[nv] = cnt;
				}
			}
		}
	}
}
