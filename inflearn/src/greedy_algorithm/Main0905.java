package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main0905 {

	// O(n) -> O(log n) PriorityQueue 이용
	/*
		입력예제
			6 9
			1 2 12
			1 3 4
			2 1 2
			2 3 5
			2 5 5
			3 4 5
			4 2 2
			4 5 5
			6 4 5
	 */

	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Edge>());
		}

		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b, c)); // LinkedList 형태로 값 생성
		}

		solution(1);
		for (int i = 2; i <= n; i++) {
			if (dis[i] != Integer.MAX_VALUE)
				System.out.println(i + " : " + dis[i]);
			else
				System.out.println(i + " : impossible");
		}
	}

	public static void solution(int v) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(v, 0));
		dis[v] = 0;
		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if (nowCost > dis[now]) continue;
			for (Edge obj : graph.get(now)) {
				if (dis[obj.vex] > nowCost + obj.cost) {
					dis[obj.vex] = nowCost + obj.cost;
					pq.offer(new Edge(obj.vex, nowCost + obj.cost));
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int vex; // 정점
	int cost; // 가중치

	public Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}


