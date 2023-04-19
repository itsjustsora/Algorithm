package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0812 {
	static int[][] board, dis;
	static int n, m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 가로
		n = Integer.parseInt(st.nextToken()); // 세로

		board = new int[n][m];
		dis = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) queue.offer(new Point(i, j));
			}
		}

		BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) flag = false;
			}
		}
		if (flag) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}
		else
			System.out.println(-1);

	}

	private static void BFS() {
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					queue.offer(new Point(nx, ny));
					dis[nx][ny] = dis[now.x][now.y] + 1;
				}
			}
		}
	}
}
