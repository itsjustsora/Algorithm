package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2644 {

	static int n, p2, answer = -1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		DFS(p1, 0);
		System.out.println(answer);
	}

	private static void DFS(int index, int cnt) {
		visited[index] = true;

		for (int x : graph.get(index)) {
			if (!visited[x]) {
				if (x == p2) {
					answer = cnt + 1;
					return;
				}
				DFS(x, cnt + 1);
			}
		}

	}
}
