package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0708 {

	/**
	 * 송아지 찾기 1 (BFS : 상태트리검색)
	 */
	static int [] dis = {1, -1, 5};
	static int[] check;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // 현수의 위치
		int E = Integer.parseInt(st.nextToken()); // 송아지의 위치

		System.out.println(bfs(S, E));

	}

	private static int bfs(int s, int e) {
		check = new int[10001];
		check[s] = 1;
		queue.offer(s);
		int L = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int x = queue.poll();
				for (int j = 0; j < 3; j++) {
					int nx = (x + dis[j]);
					if (nx == e) return L+1;
					if (0 < nx && nx <= 10000 && check[nx] == 0) {
						check[nx] = 1;
						queue.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
}
