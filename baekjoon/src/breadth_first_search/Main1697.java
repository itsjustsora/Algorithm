package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
	static int n, k;
	static int[] dis = new int[1000002];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 1000002; i++) {
			dis[i] = -1;
		}

		queue.offer(n);
		dis[n] = 0;
		BFS();

		System.out.println(dis[k]);
	}

	private static void BFS() {
		while (dis[k] == -1) {
			int now = queue.poll();

			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 0) {
					nx = now - 1;
				} else if (i == 1) {
					nx = now + 1;
				} else {
					nx = now * 2;
				}
				if (nx > 100000 || nx < 0 || dis[nx] != -1) continue;
				dis[nx] = dis[now] + 1;
				queue.offer(nx);
			}
		}
	}
}
