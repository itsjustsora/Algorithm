package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main24479 {
	static int cnt;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		visited = new int[n+1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
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
		dfs(r);

		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int index) {

		visited[index] = cnt;

		for (int i = 0; i < graph.get(index).size(); i++) {
			int cur = graph.get(index).get(i);
			if (visited[cur] == 0) {
				cnt++;
				dfs(cur);
			}
		}

	}
}
