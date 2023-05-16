package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1926 {
	static int n, m, cnt, size;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		paper = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
					max = Math.max(size, max);
					size = 0;
				}
			}
		}

		sb.append(cnt).append("\n").append(max);
		System.out.println(sb);

	}

	private static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		cnt++;
		size++;
		visited[x][y] = true;
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (!visited[nx][ny] && paper[nx][ny] == 1) {
					size++;
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny));
				}
			}
		}

	}
}

