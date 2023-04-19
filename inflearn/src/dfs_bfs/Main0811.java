package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0811 {
	static int[][] board, dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[8][8];
		dis = new int[8][8];

		StringTokenizer st;
		for (int i = 1; i <= 7; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 7; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS(1, 1);
		if (dis[7][7] == 0)
			System.out.println(-1);
		else
			System.out.println(dis[7][7]);
	}

	public static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		board[x][y] = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <=7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					queue.offer(new Point(nx, ny));
					dis[nx][ny] = dis[now.x][now.y] + 1;
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
