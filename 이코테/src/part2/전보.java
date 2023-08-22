package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보 {
	public static int n, m, start;
	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
	public static int[] d = new int[30001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i  < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node2(b, c));
		}

		Arrays.fill(d, 30001);

		dijkstra(start);

		int cnt = 0;
		int max_dist = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] != 30001) {
				cnt++;
				max_dist = Math.max(max_dist, d[i]);
			}
		}
		System.out.println(cnt - 1 + " " + max_dist);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node2> queue = new PriorityQueue<>();
		queue.offer(new Node2(start, 0));
		d[start] = 0;

		while (!queue.isEmpty()) {
			Node2 node = queue.poll();
			int dist = node.getDistance();
			int now = node.getIndex();

			if (d[now] < dist) continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				Node2 nd = graph.get(now).get(i);
				int cost = d[now] + nd.getDistance();
				if (cost < d[nd.getIndex()]) {
					d[nd.getIndex()] = cost;
					queue.offer(new Node2(nd.getIndex(), cost));
				}
			}
		}
	}
}
