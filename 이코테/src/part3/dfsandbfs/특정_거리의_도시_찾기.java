package src.part3.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 특정_거리의_도시_찾기 {

	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] d;
	public static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 도시의 개수
		m = Integer.parseInt(st.nextToken()); // 도로의 개수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

		d = new int[n+1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			d[i] = -1;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
		}

		BFS();

		boolean check = false;
		for (int i = 1; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}

		if (!check)
			System.out.println(-1);
	}

	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		d[x] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int nn = graph.get(now).get(i);
				if (d[nn] == -1) {
					d[nn] = d[now] + 1;
					queue.add(nn);
				}
			}
		}
	}
}
