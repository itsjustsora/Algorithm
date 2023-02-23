package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0714 {

	/**
	 * 그래프 최단거리(BFS)
	 * 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
	 *
	 * [입력 예제]
	 * 6 9
	 * 1 3
	 * 1 4
	 * 2 1
	 * 2 5
	 * 3 4
	 * 4 5
	 * 4 6
	 * 6 2
	 * 6 5
	 */

	static int N, M;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] check;
	static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		check = new boolean[N+1];
		dis = new int[N+1];

		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map.get(a).add(b);
		}

		BFS(1);
		for (int i = 2; i <=N; i++) {
			System.out.println(i+ " : " + dis[i]);
		}


	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();

		check[v] = true;
		dis[v] = 0;

		queue.offer(v);

		while (!queue.isEmpty()) {
			int cv = queue.poll();
			for (int nv : map.get(cv)) {
				if (!check[nv]) {
					check[nv] = true;
					queue.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}

	}
}