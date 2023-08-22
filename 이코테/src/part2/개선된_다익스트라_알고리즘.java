package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 개선된_다익스트라_알고리즘 {

	public static int n, m, start;
	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
	public static int[] d = new int[10001];

	public static void dijkstra(int start) {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		start = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node2(b, c));
		}

		Arrays.fill(d, 10001);

		dijkstra(start);

		for (int i = 1; i <= n; i++) {
			if (d[i] == 10001) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}

}

class Node2 implements Comparable<Node2> {
	private int index;
	private int distance;

	public Node2(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node2 o) {
		return this.distance - o.distance;
	}
}
