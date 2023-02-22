package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main0713 {

	/**
	 * 경로탐색 - 인접리스트
	 * 가지 수가 1000개, 10000개가 될 때 행렬을 이용하면 비효율적이다.
	 *
	 * [입력 예제]
	 * 5 9
	 * 1 2
	 * 1 3
	 * 1 4
	 * 2 1
	 * 2 3
	 * 2 5
	 * 3 4
	 * 4 2
	 * 4 5
	 */

	static int N, M, answer = 0;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		check = new boolean[N+1];

		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map.get(a).add(b);
		}

		check[1] = true;
		DFS(1);
		System.out.println(answer);


	}

	private static void DFS(int v) {
		if (v == N) answer++;
		else {
			for (int nv : map.get(v)) {
				if (!check[nv]) {
					check[nv] = true;
					DFS(nv);
					check[nv] = false;
				}
			}
		}
	}
}
