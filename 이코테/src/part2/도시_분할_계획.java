package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 도시_분할_계획 {

	/*
	7 12
	1 2 3
	1 3 2
	3 2 1
	2 5 2
	3 4 4
	7 3 6
	5 1 5
	1 6 2
	6 4 1
	6 5 3
	4 5 3
	6 7 4
	2개의 신장 트리로 분할하기 위해 가장 비용이 큰 간선 제거하기
	 */

	public static int n, m;
	public static int[] parent;


	public static int findParent(int x) {
		if (x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Edge> edges = new ArrayList<>();
		int answer = 0;

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.add(new Edge(cost, a, b));
		}

		Collections.sort(edges);
		int last = 0;

		for (int i = 0; i < edges.size(); i++) {
			Edge now = edges.get(i);

			int cost = now.getCost();
			int a = now.getNodeA();
			int b = now.getNodeB();

			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
				answer += cost;
				last = cost;
			}
		}
		System.out.println(answer - last);
	}
}

class Edge implements Comparable<Edge> {
	private int cost;
	private int nodeA;
	private int nodeB;

	public Edge(int cost, int nodeA, int nodeB) {
		this.cost = cost;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getCost() {
		return cost;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}
