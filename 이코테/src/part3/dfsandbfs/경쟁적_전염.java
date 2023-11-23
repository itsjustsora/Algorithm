package src.part3.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경쟁적_전염 {

	public static int n, k, s, x, y;
	public static int[][] map;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken()); // 초
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		for (int i = 0; i < s; i++) {
			for (int j = 1; j <= k; j++) {
				BFS(j);
				if (map[x-1][y-1] != 0) break;
			}
		}

		System.out.println(map[x-1][y-1]);
	}

	public static void BFS(int k) {
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == k) {
					queue.add(new int[] {i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0) {
					map[nx][ny] = k;
				}
			}
		}
	}
}
