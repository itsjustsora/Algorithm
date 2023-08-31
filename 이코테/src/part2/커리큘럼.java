package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 커리큘럼 {

	public static int n;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] indegree = new int[501];
	public static int[] times = new int[501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			times[i] = x;

			while (true) {
				x = Integer.parseInt(st.nextToken());

				if (x == -1) break;
				indegree[i] += 1;
				graph.get(x).add(i);
			}
		}

		topologySort();
	}

	private static void topologySort() {
		int[] result = new int[501];
		for (int i = 1; i <= n; i++) {
			result[i] = times[i];
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			ArrayList<Integer> list = graph.get(now);
			for (int i = 0; i < list.size(); i++) {
				result[list.get(i)] = Math.max(result[list.get(i)], result[now] + times[list.get(i)]);
				indegree[list.get(i)] -= 1;

				if (indegree[list.get(i)] == 0) {
					q.offer(list.get(i));
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(result[i]);
		}
	}
}
