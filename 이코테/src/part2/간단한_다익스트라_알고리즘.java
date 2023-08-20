package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 간단한_다익스트라_알고리즘 {

	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static boolean[] visited = new boolean[100001];
	public static int[] d = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
		}

		Arrays.fill(d, Integer.MAX_VALUE);

		dijkstra(start);

		for (int i = 1; i <= n; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		d[start] = 0;
		visited[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			Node node = graph.get(start).get(i);
			d[node.getIndex()] = node.getDistance();
		}

		for (int i = 0; i < n - 1; i++) {
			int now = getSmallestNode();
			visited[now] = true;
			for (int j = 0; j < graph.get(now).size(); j++) {
				Node node = graph.get(now).get(j);
				int cost = d[now] + node.getDistance();
				if (cost < node.getIndex()) {
					d[node.getIndex()] = cost;
				}

			}
		}
	}

	private static int getSmallestNode() {
		int min_value = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] < min_value && !visited[i]) {
				min_value = d[i];
				idx = i;
			}
		}
		return idx;
	}
}

class Node {
	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}
}
